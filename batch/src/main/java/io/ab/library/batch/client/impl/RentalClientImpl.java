
package io.ab.library.batch.client.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import io.ab.library.batch.client.RentalClient;
import io.ab.library.batch.wsdl.GetAllRentalsResponse;
import io.ab.library.batch.wsdl.ObjectFactory;
import io.ab.library.batch.wsdl.Rental;

@Component
public class RentalClientImpl extends WebServiceGatewaySupport implements RentalClient {

	private static final Logger log = LoggerFactory.getLogger(RentalClientImpl.class);
	
	private ObjectFactory objectFactory;
	
	public RentalClientImpl(Jaxb2Marshaller marshaller, ObjectFactory objectFactory) {
		super();
		this.objectFactory = objectFactory;
		this.setDefaultUri("http://localhost:8000/soap");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}

	public List<Rental> getAllRentals() {
		log.info("performing GetAllRentalsRequest");

		GetAllRentalsResponse response = (GetAllRentalsResponse) getWebServiceTemplate()
				.marshalSendAndReceive(this.objectFactory.createGetAllRentalsRequest(null));

		return response.getRentals();
	}

}
