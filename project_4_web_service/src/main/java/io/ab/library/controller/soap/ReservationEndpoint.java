package io.ab.library.controller.soap;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.request.AddReservationRequest;
import io.ab.library.controller.soap.request.DeleteReservationRequest;
import io.ab.library.controller.soap.request.GetAllReservationByAccountRequest;
import io.ab.library.controller.soap.request.GetAllReservationByBookRequest;
import io.ab.library.controller.soap.response.GetAllReservationByAccountResponse;
import io.ab.library.controller.soap.response.GetAllReservationByBookResponse;
import io.ab.library.controller.soap.response.AddReservationResponse;
import io.ab.library.model.Reservation;
import io.ab.library.service.ReservationService;
import io.ab.library.util.exception.AlreadyExistsException;

@Endpoint
public class ReservationEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private io.ab.library.controller.soap.response.ObjectFactory responseFactory;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addReservationRequest")
	@ResponsePayload
	public AddReservationResponse addReservation(@RequestPayload AddReservationRequest request)
			throws AlreadyExistsException, SOAPException {
		AddReservationResponse response = new AddReservationResponse();
		System.out.println("processing addReservationRequest");

		Reservation reservation = this.reservationService.insertNewReservation(request.getAccountId(), request.getBookId());
		response.setReservation(reservation);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReservationByAccountRequest")
	@ResponsePayload
	public GetAllReservationByAccountResponse getAllReservationByAccount(@RequestPayload GetAllReservationByAccountRequest request)
			throws AlreadyExistsException, SOAPException {
		GetAllReservationByAccountResponse response = new GetAllReservationByAccountResponse();
		System.out.println("processing getAllReservationByAccountRequest");

		List<Reservation> reservations = this.reservationService.findAllByAccount(request.getAccountId());
		response.setReservations(reservations);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllReservationByBookRequest")
	@ResponsePayload
	public GetAllReservationByBookResponse getAllReservationByBook(@RequestPayload GetAllReservationByBookRequest request)
			throws AlreadyExistsException, SOAPException {
		GetAllReservationByBookResponse response = new GetAllReservationByBookResponse();
		System.out.println("processing getAllReservationByBookRequest");

		List<Reservation> reservations = this.reservationService.findAllByBook(request.getBookId());
		response.setReservations(reservations);

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReservationRequest")
	@ResponsePayload
	public JAXBElement<Object> deleteReservation(@RequestPayload DeleteReservationRequest request) {
		System.out.println("processing deleteReservation");
		this.reservationService.deleteOne(request.getAccountId(), request.getBookId());

		return responseFactory.createDeleteReservationResponse(null);
	}
}
