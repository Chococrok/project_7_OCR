package io.ab.library.webapp.client.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.AccountClient;
import io.ab.library.webapp.client.RentalClient;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.GetAllBooksResponse;
import io.ab.library.webapp.wsdl.GetRentalsByUserRequest;
import io.ab.library.webapp.wsdl.GetRentalsByUserResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignInRequest;
import io.ab.library.webapp.wsdl.SignInResponse;
import io.ab.library.webapp.wsdl.SignUpForm;
import io.ab.library.webapp.wsdl.SignUpRequest;
import io.ab.library.webapp.wsdl.UpdateRentalRequest;
import io.ab.library.webapp.wsdl.UpdateRentalResponse;

@Component
public class RentalClientSoap extends AbstractClientSoap implements RentalClient {

	public RentalClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Rental> getRentalsByUser(int id) {
		this.logger.debug("performing getRentalsByUser");

		GetRentalsByUserRequest request = new GetRentalsByUserRequest();
		request.setId(BigInteger.valueOf(id));

		GetRentalsByUserResponse response = (GetRentalsByUserResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap", request, null);
		return response.getRentals();
	}

	public Rental updateRental(Rental rental) {
		this.logger.debug("performing UpdateRentalRequest");

		UpdateRentalRequest request = new UpdateRentalRequest();
		request.setRental(rental);

		UpdateRentalResponse response = (UpdateRentalResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap", request, null);
		return response.getRental();
	}

}
