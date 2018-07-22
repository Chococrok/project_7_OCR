package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Reservation;

public interface ReservationClient {

	List<Reservation> getAllReservationByAccount(int accountId);

	Reservation addReservation(int accountId, int bookId);

}
