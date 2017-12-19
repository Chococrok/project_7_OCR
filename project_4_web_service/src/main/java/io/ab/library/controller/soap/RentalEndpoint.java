package io.ab.library.controller.soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.response.GetAllAuthorsResponse;
import io.ab.library.repository.AuthorRepository;
import io.ab.library.service.impl.AuthorServiceImpl;

@Endpoint
public class RentalEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private AuthorServiceImpl authorService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRentalsRequest")
	@ResponsePayload
	public GetAllAuthorsResponse getAllAuthors() {
		GetAllAuthorsResponse response = new GetAllAuthorsResponse();
		System.out.println("processing author request");
		
//		this.authorService.getAllAuthors().forEach(author -> {
//			response.getAuthors().add(author);
//		});

		return response;
	}
}