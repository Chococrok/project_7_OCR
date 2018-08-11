package io.ab.library.service;

import java.util.Calendar;
import java.util.List;

import javax.xml.soap.SOAPException;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;
import io.ab.library.util.exception.AlreadyExistsException;

public interface ReservationService {

	int getReservationDuration();
	Reservation findFirstReservation(int bookId);
	Reservation insertNewReservation(int accountId, int bookId) throws AlreadyExistsException, SOAPException;
	List<Reservation> findAllByAccount(int accountId);
	List<Book> addReservationsToBooks(Iterable<Book> iterable);
	Reservation findOneByAccountAndByBook(int accountId, int bookId);
	List<Reservation> findAllByBook(int bookId);
	Reservation updateOne(Reservation reservation);
	void deleteOne(int accountId, int bookId);
	void deleteOne(ReservationPK id);
	Calendar scheduleFirstReservationUpdate(Reservation reservation);
	Calendar scheduleFirstReservationUpdate(int bookId);
}
