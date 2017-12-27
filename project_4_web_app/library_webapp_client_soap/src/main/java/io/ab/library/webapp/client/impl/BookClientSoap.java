
package io.ab.library.webapp.client.impl;

import java.util.List;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.BookClient;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.GetAllBooksResponse;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.SearchBooksByAuthorRequest;
import io.ab.library.webapp.wsdl.SearchBooksByBookRequest;
import io.ab.library.webapp.wsdl.SearchBooksByPublisherRequest;
import io.ab.library.webapp.wsdl.SearchBooksByTagRequest;
import io.ab.library.webapp.wsdl.SearchBooksResponse;

@Component
public class BookClientSoap extends AbstractClientSoap implements BookClient {

	public BookClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public List<Book> getAllBooks() {
		this.logger.debug("performing GetAllBooksRequest");
		
		this.objectFactory = new ObjectFactory();

		GetAllBooksResponse response = (GetAllBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						objectFactory.createGetAllBooksRequest(null),
						null);
		return response.getBooks();
	}

	public List<Book> searchBooksByBookName(String search) {
		this.logger.debug("performing SearchBooksByBookRequest with search value: " + search);
		
		SearchBooksByBookRequest searchRequest = new SearchBooksByBookRequest();
		searchRequest.setSearch(search);
		
		SearchBooksResponse response = (SearchBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						searchRequest,
						null);
		return response.getBooks();
	}

	public List<Book> searchBooksByAuthorName(String search) {
		this.logger.debug("performing SearchBooksByAuthorRequest with search value: " + search);
		
		SearchBooksByAuthorRequest searchRequest = new SearchBooksByAuthorRequest();
		searchRequest.setSearch(search);
		
		SearchBooksResponse response = (SearchBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						searchRequest,
						null);
		return response.getBooks();
	}

	public List<Book> searchBooksByPublisherName(String search) {
		this.logger.debug("performing SearchBooksByPublisherRequest with search value: " + search);
		
		SearchBooksByPublisherRequest searchRequest = new SearchBooksByPublisherRequest();
		searchRequest.setSearch(search);
		
		SearchBooksResponse response = (SearchBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						searchRequest,
						null);
		return response.getBooks();
	}

	public List<Book> searchBooksByTagName(String search) {
		this.logger.debug("performing SearchBooksByTagRequest with search value: " + search);
		
		SearchBooksByTagRequest searchRequest = new SearchBooksByTagRequest();
		searchRequest.setSearch(search);
		
		SearchBooksResponse response = (SearchBooksResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/soap",
						searchRequest,
						null);
		return response.getBooks();
	}

}
