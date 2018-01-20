package io.ab.library.webapp.client.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import javax.annotation.PostConstruct;

import io.ab.library.webapp.wsdl.ObjectFactory;

public abstract class AbstractClientSoap extends WebServiceGatewaySupport {
	
	protected final static Logger logger = LogManager.getRootLogger();
	
	protected ObjectFactory objectFactory;
	
	@Value("${library.service.host}")
	private String host;
	@Value("${library.service.port}")
	private String port;
	protected String serviceUrl;
	
	public AbstractClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super();
		this.objectFactory = objectFactory;
		
		
		this.setMarshaller(marshaller);
		this.setUnmarshaller(marshaller);
	}
	
	@PostConstruct
	public void init() {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append("http://");
		urlBuilder.append(host);
		urlBuilder.append(":");
		urlBuilder.append(port);
		urlBuilder.append("/soap");
		this.serviceUrl = urlBuilder.toString();
		
		this.logger.info("### app configured to use webservice at: " + this.serviceUrl + " ###");
		
		this.setDefaultUri(this.serviceUrl);
	}


}
