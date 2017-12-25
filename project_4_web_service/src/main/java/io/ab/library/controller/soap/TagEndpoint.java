package io.ab.library.controller.soap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.response.GetAllAuthorsResponse;
import io.ab.library.controller.soap.response.GetAllTagsResponse;
import io.ab.library.repository.AuthorRepository;
import io.ab.library.service.impl.AuthorServiceImpl;
import io.ab.library.service.impl.TagServiceImpl;

@Endpoint
public class TagEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private TagServiceImpl tagService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTagsRequest")
	@ResponsePayload
	public GetAllTagsResponse getAllTags() {
		GetAllTagsResponse response = new GetAllTagsResponse();
		System.out.println("processing getAllTags request");
		
		this.tagService.findAll().forEach(tag -> {
			response.getTags().add(tag);
		});

		return response;
	}
}
