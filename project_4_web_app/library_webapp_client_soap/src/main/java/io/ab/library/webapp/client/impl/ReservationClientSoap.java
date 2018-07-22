package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.ReservationClient;
import io.ab.library.webapp.wsdl.GetAllReservationByAccountRequest;
import io.ab.library.webapp.wsdl.GetAllReservationByAccountResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.Reservation;

@Component
public class ReservationClientSoap extends AbstractClientSoap implements ReservationClient {

	public ReservationClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Reservation> getAllReservationByAccount(int accountId) {
		GetAllReservationByAccountRequest request = new GetAllReservationByAccountRequest();
		request.setAccountId(accountId);
		
		GetAllReservationByAccountResponse response = (GetAllReservationByAccountResponse) this.getWebServiceTemplate().marshalSendAndReceive(request); 
		return response.getReservations();
	}

}
