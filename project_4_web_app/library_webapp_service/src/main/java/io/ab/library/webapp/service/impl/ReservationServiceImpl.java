package io.ab.library.webapp.service.impl;

import io.ab.library.webapp.service.ReservationService;
import io.ab.library.webapp.wsdl.Reservation;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {

	@Override
	public Reservation addReservation(int accountId, int bookId) {
		return this.reservationClient.addReservation(accountId, bookId);
	}
	
	@Override
	public List<Reservation> findAllReservationByAccount(int accountId) {
		return this.reservationClient.getAllReservationByAccount(accountId);
	}
	
	@Override
	public void deleteReservation(int accountId, int bookId) {
		this.reservationClient.deleteReservation(accountId, bookId);
	}
}
