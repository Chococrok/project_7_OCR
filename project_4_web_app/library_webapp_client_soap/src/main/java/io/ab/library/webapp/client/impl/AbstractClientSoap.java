package io.ab.library.webapp.client.impl;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import io.ab.library.webapp.wsdl.ObjectFactory;

public abstract class AbstractClientSoap extends WebServiceGatewaySupport {
	
	protected ObjectFactory objectFactory;
		
	public AbstractClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super();
		this.objectFactory = objectFactory;
		this.setDefaultUri("http://localhost:8080/soap");
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	
	


}
