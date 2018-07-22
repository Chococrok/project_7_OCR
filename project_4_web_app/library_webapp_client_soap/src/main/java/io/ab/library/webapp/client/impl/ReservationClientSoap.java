package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.ReservationClient;
import io.ab.library.webapp.wsdl.GetAllReservationByAccountRequest;
import io.ab.library.webapp.wsdl.GetAllReservationByAccountResponse;
import io.ab.library.webapp.wsdl.AddReservationRequest;
import io.ab.library.webapp.wsdl.AddReservationResponse;
import io.ab.library.webapp.wsdl.DeleteReservationRequest;
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
		this.logger.debug("performing getAllReservationByAccount with parameters: " + " accountId= " + accountId);
		
		GetAllReservationByAccountRequest request = new GetAllReservationByAccountRequest();
		request.setAccountId(accountId);
		
		GetAllReservationByAccountResponse response = (GetAllReservationByAccountResponse) this.getWebServiceTemplate().marshalSendAndReceive(request); 
		return response.getReservations();
	}
	
	@Override
	public Reservation addReservation(int accountId, int bookId) {
		this.logger.debug("performing addReservation with parameters: " + " accountId= " + accountId +  " bookId= " + bookId);
		
		AddReservationRequest request = new AddReservationRequest();
		request.setAccountId(accountId);
		request.setBookId(bookId);
		
		AddReservationResponse response = (AddReservationResponse) this.getWebServiceTemplate().marshalSendAndReceive(request);
		
		return response.getReservation();
	}
	
	@Override
	public Object deleteReservation(int accountId, int bookId) {
		this.logger.debug("performing deleteReservation with parameters: " + " accountId= " + accountId +  " bookId= " + bookId);
		
		DeleteReservationRequest request = new DeleteReservationRequest();
		request.setAccountId(accountId);
		request.setBookId(bookId);
		
		return this.getWebServiceTemplate().marshalSendAndReceive(request);
	}

}
