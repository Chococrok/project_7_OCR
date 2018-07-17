package io.ab.library.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.xml.soap.SOAPException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;
import io.ab.library.repository.ReservationRepository;
import io.ab.library.service.BookService;
import io.ab.library.service.FaultService;
import io.ab.library.service.RentalService;
import io.ab.library.service.ReservationService;
import io.ab.library.util.exception.AlreadyExistsException;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private RentalService rentalService;

	@Autowired
	private FaultService faultService;

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

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
		Reservation newReservation;

		boolean reservationExists = this.reservationRepository.exists(new ReservationPK(accountId, bookId));
		boolean userIsAlreadyRenting = this.rentalService.exists(accountId, bookId);
		boolean otherReservation = this.reservationRepository.findAllByBook(bookId).size() > 0;
		boolean maxReservationReached = currentBookReservations.size() >= involvedBook.getCopy() * 2;
		boolean available = this.bookService.isAvailable(bookId);

		if (reservationExists || userIsAlreadyRenting) {
			String faultMessage = "User already booked or is already renting this book";
			log.error(faultMessage);
			this.faultService.sendNewClientSoapFault(faultMessage);
		}

		if (available) {
			String faultMessage = "trying to book an an available resource";
			log.error(faultMessage);
			this.faultService.sendNewClientSoapFault(faultMessage);
		}

		if (maxReservationReached) {
			String faultMessage = "max reservation reached";
			log.error(faultMessage);
			this.faultService.sendNewClientSoapFault(faultMessage);
		}

		// If there is no other reservation it means that the user is the first one.
		// Therefore the deadline is set.

		if (!otherReservation) {
			int currentDay = Calendar.getInstance().get(Calendar.MINUTE);
			Calendar deadLine = Calendar.getInstance();
			deadLine.set(Calendar.MINUTE, currentDay + 1);

			newReservation = new Reservation(accountId, bookId, deadLine.getTime());

			threadPoolTaskScheduler.schedule(new ReservationUpdater(this, newReservation), deadLine.getTime());
		} else {
			newReservation = new Reservation(accountId, bookId);
		}

		return this.reservationRepository.save(newReservation);
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
	public void deleteOne(ReservationPK id) {
		this.reservationRepository.delete(id);
	}

	private class ReservationUpdater implements Runnable {

		private ReservationService reservationService;
		private Reservation previousFirstReservation;

		public ReservationUpdater(ReservationService reservationService, Reservation reservation) {
			this.reservationService = reservationService;
			this.previousFirstReservation = reservation;
		}

		@Override
		public void run() {
			this.reservationService.deleteOne(this.previousFirstReservation.getId());

			int bookId = this.previousFirstReservation.getId().getBookId();
			Reservation currentFirstResrvation = this.reservationService.findFirstReservation(bookId);

			int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			Calendar deadLine = Calendar.getInstance();
			deadLine.set(Calendar.DAY_OF_MONTH, currentDay + 2);

			currentFirstResrvation.setReservationEnd(deadLine.getTime());
			this.reservationService.updateOne(currentFirstResrvation);
		}
	}
}