package io.ab.library.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.xml.soap.SOAPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;
import io.ab.library.repository.ReservationRepository;
import io.ab.library.service.BookService;
import io.ab.library.service.MailService;
import io.ab.library.service.RentalService;
import io.ab.library.service.ReservationService;
import io.ab.library.util.FaultThrower;
import io.ab.library.util.exception.AlreadyExistsException;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Value("${application.reservation-duration}")
	private int reservationDuration;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private RentalService rentalService;

	@Autowired
	private MailService mailService;

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	// Map containing the sheduledFuture by book
	private Map<Integer, ScheduledFuture<?>> scheduledFutureMap = new HashMap<>();

	@PostConstruct
	private void loadReservationUpdate() {
		this.bookService.getAll().forEach(book -> {
			Reservation reservation = this.findFirstReservation(book.getId());

			if (reservation != null && reservation.getReservationEnd() != null) {
				ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleAtFixedRate(
						new ReservationUpdater(this, this.mailService, book.getId()),
						reservation.getReservationEnd(),
						this.getReservationDurationInMillis());
				
				scheduledFutureMap.put(book.getId(), scheduledFuture);
			}
		});
	}
	
	@Override
	public int getReservationDuration() {
		return this.reservationDuration;
	}

	@Override
	public int getReservationDurationInMillis() {
		return this.reservationDuration * 60 * 60 * 1000;
	}

	@Override
	public Reservation findFirstReservation(int bookId) {
		try {
			Book book = new Book(bookId);
			return reservationRepository.findFirstByBookOrderByAccountIdAsc(book);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reservation insertNewReservation(int accountId, int bookId) throws AlreadyExistsException, SOAPException {
		List<Reservation> currentBookReservations = this.reservationRepository.findAllByBook(bookId);
		Book involvedBook = this.bookService.findOne(bookId);

		if (involvedBook == null) {
			FaultThrower.sendNewClientSoapFault("book with id: " + bookId + " doesn't exist");
		}

		boolean reservationExists = this.reservationRepository.exists(new ReservationPK(accountId, bookId));
		boolean userIsAlreadyRenting = this.rentalService.exists(accountId, bookId);
		boolean maxReservationReached = currentBookReservations.size() >= involvedBook.getCopy() * 2;
		boolean available = this.bookService.isAvailable(bookId);

		if (reservationExists || userIsAlreadyRenting) {
			String faultMessage = "User already booked or is already renting this book";
			log.error(faultMessage);
			FaultThrower.sendNewClientSoapFault(faultMessage);
		}

		if (available) {
			String faultMessage = "trying to book an an available resource";
			log.error(faultMessage);
			FaultThrower.sendNewClientSoapFault(faultMessage);
		}

		if (maxReservationReached) {
			String faultMessage = "max reservation reached";
			log.error(faultMessage);
			FaultThrower.sendNewClientSoapFault(faultMessage);
		}

		return this.reservationRepository.save(new Reservation(accountId, bookId));
	}

	@Override
	public List<Reservation> findAllByAccount(int accountId) {
		return this.reservationRepository.findAllByAccount(accountId);
	}

	@Override
	public List<Reservation> findAllByBook(int bookId) {
		return this.reservationRepository.findAllByBook(bookId);
	}

	@Override
	public Reservation findOneByAccountAndByBook(int accountId, int bookId) {
		return this.reservationRepository.findOneByAccountAndByBook(accountId, bookId);
	}

	@Override
	public Reservation updateOne(Reservation reservation) {
		return this.reservationRepository.save(reservation);
	}

	@Override
	public void deleteOne(int accountId, int bookId) {
		this.deleteOne(new ReservationPK(accountId, bookId));
	}

	@Override
	public void deleteOne(ReservationPK id) {
		this.reservationRepository.delete(id);
	}

	@Override
	public Calendar scheduleFirstReservationUpdate(int bookId) {
		Reservation reservation = this.findFirstReservation(bookId);
		Calendar deadLine = null;

		if (reservation != null) {
			int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			deadLine = Calendar.getInstance();
			deadLine.set(Calendar.HOUR_OF_DAY, currentHour + this.reservationDuration);

			reservation.setReservationEnd(deadLine.getTime());
			this.updateOne(reservation);

			ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.scheduleAtFixedRate(
					new ReservationUpdater(this, this.mailService, bookId), 
					reservation.getReservationEnd(),
					this.getReservationDurationInMillis());
			
			scheduledFutureMap.put(bookId, scheduledFuture);

			this.mailService.sendBookAvailable(reservation.getAccount(), reservation.getBook());
		}

		return deadLine;
	}
	
	@Override
	public void cancelReservationUpdate(int bookId) {
		ScheduledFuture<?> future = this.scheduledFutureMap.get(bookId);
		
		if (future != null) {
			future.cancel(false);
		}
	}

	@Override
	public List<Book> addReservationsToBooks(Iterable<Book> iterable) {
		List<Book> books = new ArrayList<Book>();

		for (Book book : iterable) {
			book.setReservations(this.findAllByBook(book.getId()));
			books.add(book);
		}
		return books;
	}

	// internal class to schedule reservation update
	private class ReservationUpdater implements Runnable {

		private ReservationService reservationService;
		private MailService mailService;
		private int bookId;

		public ReservationUpdater(ReservationService reservationService, MailService mailService, int bookId) {
			this.reservationService = reservationService;
			this.mailService = mailService;
			this.bookId = bookId;
		}

		@Override
		public void run() {
			Reservation reservation = this.reservationService.findFirstReservation(bookId);

			if (reservation != null) {
				this.reservationService.deleteOne(reservation.getId());

				reservation = this.reservationService.findFirstReservation(bookId);

				if (reservation != null) {
					int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
					Calendar deadLine = Calendar.getInstance();
					deadLine.set(Calendar.HOUR_OF_DAY, currentHour + reservationService.getReservationDuration());

					reservation.setReservationEnd(deadLine.getTime());
					reservationService.updateOne(reservation);
					
					this.mailService.sendBookAvailable(reservation.getAccount(), reservation.getBook());
				} else {
					this.reservationService.cancelReservationUpdate(bookId);
				}
			} else {
				this.reservationService.cancelReservationUpdate(bookId);
			}
		}
	}
}
