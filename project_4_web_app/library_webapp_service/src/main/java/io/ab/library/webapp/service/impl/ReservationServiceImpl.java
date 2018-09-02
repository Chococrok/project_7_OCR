package io.ab.library.webapp.service.impl;

import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.service.ReservationService;
import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.service.pojo.ReservationPOJO;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Reservation;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl extends AbstractService implements ReservationService {
	
	@Autowired
	protected BookService bookService;

	@Override
	public Reservation addReservation(int accountId, int bookId) {
		return this.reservationClient.addReservation(accountId, bookId);
	}
	
	@Override
	public List<Reservation> findAllReservationByAccount(int accountId) {
		List<BookPOJO> books = this.bookService.modelsToPOJOs(this.bookService.getAllBooks());

		List<Reservation> reservations = this.reservationClient.getAllReservationByAccount(accountId)
				.parallelStream()
				.map(reservation -> {
					int actualReservationNumber = 1;
					int userReservationNumber = reservation.getReservationNumber();
					
					for (Book book : books) {
						if (book.getId() == reservation.getBook().getId()) {
							reservation.setBook(book);
							
							for (Reservation bookReservation : book.getReservations()) {
								int reservationNumber = bookReservation.getReservationNumber();
								
								if (reservationNumber > 0 && reservationNumber < userReservationNumber) {
									actualReservationNumber += 1;
								}
							}
						}
					}
					
					reservation.setReservationNumber(actualReservationNumber);
					
					return reservation;
				}).collect(Collectors.toList());
		return reservations;
	}
	
	@Override
	public void deleteReservation(int accountId, int bookId) {
		this.reservationClient.deleteReservation(accountId, bookId);
	}
	

	@Override
	public List<ReservationPOJO> modelsToPojos(List<Reservation> reservations) {
		return reservations.stream().map(ReservationPOJO::new).collect(Collectors.toList());
	}
}
