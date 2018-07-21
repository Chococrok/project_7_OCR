package io.ab.library.webapp.client.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.RentalClient;
import io.ab.library.webapp.wsdl.GetRentalByIdRequest;
import io.ab.library.webapp.wsdl.GetRentalByIdResponse;
import io.ab.library.webapp.wsdl.GetRentalsByUserRequest;
import io.ab.library.webapp.wsdl.GetRentalsByUserResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.UpdateRentalRequest;
import io.ab.library.webapp.wsdl.UpdateRentalResponse;

@Component
public class ReservationClientSoap extends AbstractClientSoap implements RentalClient {

	public ReservationClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Rental> getRentalsByUser(int id) {
		this.logger.debug("performing getRentalsByUser");

		GetRentalsByUserRequest request = new GetRentalsByUserRequest();
		request.setId(BigInteger.valueOf(id));

		GetRentalsByUserResponse response = (GetRentalsByUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response.getRentals();
	}

	public Rental updateRental(Rental rental) {
		this.logger.debug("performing UpdateRentalRequest: " + rental.toJson());

		UpdateRentalRequest request = new UpdateRentalRequest();
		request.setRental(rental);

		UpdateRentalResponse response = (UpdateRentalResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response.getRental();
	}

	public Rental findOne(int accountId, int bookId) {
		this.logger.debug("performing GetRentalByIdRequest with param:" + BigInteger.valueOf(accountId) + " "
				+ BigInteger.valueOf(bookId));

		GetRentalByIdRequest request = new GetRentalByIdRequest();
		request.setAccountId(BigInteger.valueOf(accountId));
		request.setBookId(BigInteger.valueOf(bookId));

		GetRentalByIdResponse response = (GetRentalByIdResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response.getRental();
	}

}
