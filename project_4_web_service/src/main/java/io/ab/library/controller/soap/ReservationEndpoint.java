package io.ab.library.controller.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.request.AddReservationRequest;
import io.ab.library.controller.soap.response.AddReservationResponse;
import io.ab.library.model.Reservation;
import io.ab.library.service.ReservationService;
import io.ab.library.util.exception.AlreadyExistsException;

@Endpoint
public class ReservationEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private ReservationService rentalService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addReservationRequest")
	@ResponsePayload
	public AddReservationResponse addReservation(@RequestPayload AddReservationRequest request)
			throws AlreadyExistsException {
		AddReservationResponse response = new AddReservationResponse();
		System.out.println("processing addReservationRequest");

		Reservation reservation = this.rentalService.insertNewReservation(request.getAccountId(), request.getBookId());
		response.setReservation(reservation);

		return response;
	}
}
