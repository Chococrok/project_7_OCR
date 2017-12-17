package io.ab.library.controller.soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.response.GetAllBooksResponse;
import io.ab.library.service.BookService;

@Endpoint
public class BookEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private BookService bookService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBooksRequest")
	@ResponsePayload
	public GetAllBooksResponse getAllBooks() {
		GetAllBooksResponse response = new GetAllBooksResponse();
		System.out.println("processing getAllBooks");
		
		this.bookService.getAll().forEach(book -> {
			response.getBooks().add(book);
		});

		return response;
	}
}
