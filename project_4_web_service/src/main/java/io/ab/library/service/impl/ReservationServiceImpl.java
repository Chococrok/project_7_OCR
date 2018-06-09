package io.ab.library.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;
import io.ab.library.repository.ReservationRepository;
import io.ab.library.service.ReservationService;
import io.ab.library.util.exception.AlreadyExistsException;

@Service
public class ReservationServiceImpl implements ReservationService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation findLastReservation(Book book) {
		try {
			return reservationRepository.findFirstByBookOrderByAccountIdAsc(book);			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reservation insertNewReservation(int accountId, int bookId) throws AlreadyExistsException {
		boolean reservationExists = this.reservationRepository.exists(new ReservationPK(accountId, bookId));
		boolean otherReservation = this.reservationRepository.findAllByBook(new Book(bookId)).size() > 0;
		
		if (!reservationExists && !otherReservation) {
			//TODO set date at d+2
			return this.reservationRepository.save(new Reservation(accountId, bookId, new Date()));			
		} else if (!reservationExists) {
			return this.reservationRepository.save(new Reservation(accountId, bookId));
		}else {
			AlreadyExistsException e = new AlreadyExistsException("reservation");
			log.warn(e.getMessage() + " accountId: " + accountId + " bookId: " + bookId);
			throw e;
		}
	}


}
