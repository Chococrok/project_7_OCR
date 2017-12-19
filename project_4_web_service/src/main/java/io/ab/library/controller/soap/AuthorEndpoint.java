package io.ab.library.controller.soap;


import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.response.GetAllAuthorsResponse;
import io.ab.library.service.AuthorService;

@Endpoint
public class AuthorEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private AuthorService authorService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAuthorsRequest")
	@ResponsePayload
	public GetAllAuthorsResponse getAllAuthors(@RequestPayload JAXBElement<Object> jax) {
		GetAllAuthorsResponse response = new GetAllAuthorsResponse();
		System.out.println("processing author request");
		
		this.authorService.getAll().forEach(author -> {
			response.getAuthors().add(author);
		});
		
		response.getAuthors().forEach(author -> {
			System.out.println(author.getFirstName());
			System.out.println(author.getLastName());
			System.out.println("*****");
		});

		return response;
	}
}
