
package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.BookClient;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.GetAllBooksResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;

@Component
public class BookClientSoap extends AbstractClientSoap implements BookClient {

	public BookClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Book> getBooks() {
		
		this.objectFactory = new ObjectFactory();

		GetAllBooksResponse response = (GetAllBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						objectFactory.createGetAllBooksRequest(null),
						null);
		return response.getBooks();
	}

}
