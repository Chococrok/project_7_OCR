package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;

public interface ReservationClient {

	List<Reservation> getAllReservationByAccount(int accountId);

}
