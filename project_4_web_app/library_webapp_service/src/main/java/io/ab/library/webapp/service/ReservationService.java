package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.service.pojo.ReservationPOJO;
import io.ab.library.webapp.wsdl.Reservation;

public interface ReservationService  {
	
	Reservation addReservation(int accountId, int bookId);
	List<Reservation> findAllReservationByAccount(int accountId);
	void deleteReservation(int accountId, int bookId);
	List<ReservationPOJO> modelsToPojos(List<Reservation> reservations);
}
