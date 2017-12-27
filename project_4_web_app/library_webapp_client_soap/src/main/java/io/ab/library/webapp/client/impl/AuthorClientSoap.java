
package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.AuthorClient;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.GetAllAuthorsResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;

@Component
public class AuthorClientSoap extends AbstractClientSoap implements AuthorClient {

	public AuthorClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Author> getAllAuthors() {
		
		this.objectFactory = new ObjectFactory();

		GetAllAuthorsResponse response = (GetAllAuthorsResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						objectFactory.createGetAllAuthorsRequest(null),
						null);
		return response.getAuthors();
	}

}
