package io.ab.library.service;

import javax.xml.soap.SOAPException;

import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;
import io.ab.library.util.exception.AlreadyExistsException;

public interface ReservationService {

	Reservation findFirstReservation(int bookId);
	Reservation insertNewReservation(int accountId, int bookId) throws AlreadyExistsException, SOAPException;
	Iterable<Reservation> findAllByAccount(int accountId);
	
	Reservation findOneByAccountAndByBook(int accountId, int bookId);
	Iterable<Reservation> findAllByBook(int bookId);
	Reservation updateOne(Reservation reservation);
	void deleteOne(ReservationPK id);
}
