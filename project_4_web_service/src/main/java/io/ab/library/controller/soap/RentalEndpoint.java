package io.ab.library.controller.soap;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.request.GetRentalsByUserRequest;
import io.ab.library.controller.soap.request.UpdateRentalRequest;
import io.ab.library.controller.soap.response.GetRentalsByUserResponse;
import io.ab.library.controller.soap.response.UpdateRentalResponse;
import io.ab.library.service.impl.RentalServiceImpl;

@Endpoint
public class RentalEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private RentalServiceImpl rentalService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRentalsByUserRequest")
	@ResponsePayload
	public GetRentalsByUserResponse getAllRentals(@RequestPayload GetRentalsByUserRequest request) {
		GetRentalsByUserResponse response = new GetRentalsByUserResponse();
		System.out.println("processing GetRentalsByUserRequest");
		
		this.rentalService.findByUser(request.getId().intValue()).forEach(rental -> {
			response.getRentals().add(rental);
		});

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateRentalRequest")
	@ResponsePayload
	public UpdateRentalResponse updateRental(@RequestPayload UpdateRentalRequest request) {
		UpdateRentalResponse response = new UpdateRentalResponse();
		System.out.println("processing updateRentalRequest");
		
		response.setRental(this.rentalService.update(request.getRental()));

		return response;
	}
}
