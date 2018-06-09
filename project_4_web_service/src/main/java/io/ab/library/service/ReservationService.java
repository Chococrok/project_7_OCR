package io.ab.library.service;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.util.exception.AlreadyExistsException;

public interface ReservationService {

	public Reservation findLastReservation(Book book);
	public Reservation insertNewReservation(int accountId, int bookId) throws AlreadyExistsException;
}
