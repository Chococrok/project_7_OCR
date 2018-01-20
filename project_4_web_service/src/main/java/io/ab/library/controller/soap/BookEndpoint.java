package io.ab.library.controller.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.request.SearchBooksByAuthorRequest;
import io.ab.library.controller.soap.request.SearchBooksByBookRequest;
import io.ab.library.controller.soap.request.SearchBooksByPublisherRequest;
import io.ab.library.controller.soap.request.SearchBooksByTagRequest;
import io.ab.library.controller.soap.response.GetAllBooksResponse;
import io.ab.library.controller.soap.response.SearchBooksResponse;
import io.ab.library.service.BookService;

@Endpoint
public class BookEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";
	
	private static final Logger log = LoggerFactory.getLogger(BookEndpoint.class);

	@Autowired
	private BookService bookService;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBooksRequest")
	@ResponsePayload
	public GetAllBooksResponse getAllBooksWithRentals() {
		GetAllBooksResponse response = new GetAllBooksResponse();
		log.info("processing getAllBooks");
		
		log.info("################## \n ###" + datasourceUrl);

		this.bookService.getAllWithRentals().forEach(book -> {
			response.getBooks().add(book);
		});

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksByBookRequest")
	@ResponsePayload
	public SearchBooksResponse searchBooksByBookName(@RequestPayload SearchBooksByBookRequest request) {
		SearchBooksResponse response = new SearchBooksResponse();
		log.info("processing searchBooksByBookRequest with search value: " + request.getSearch());

		this.bookService.findByNameContaining(request.getSearch()).forEach(book -> {
			response.getBooks().add(book);
			log.info("-> found: ", book.getName());
		});

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksByAuthorRequest")
	@ResponsePayload
	public SearchBooksResponse searchBooksByAuthorName(@RequestPayload SearchBooksByAuthorRequest request) {
		SearchBooksResponse response = new SearchBooksResponse();
		log.info("processing searchBooksByAuthorRequest with search value: " + request.getSearch());

		this.bookService.findByAuthorFirstNameOrLastNameContaining(request.getSearch()).forEach(book -> {
			response.getBooks().add(book);
			log.info("-> found: " + book.getName());

		});

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksByPublisherRequest")
	@ResponsePayload
	public SearchBooksResponse searchBooksByPublisherName(@RequestPayload SearchBooksByPublisherRequest request) {
		SearchBooksResponse response = new SearchBooksResponse();
		log.info("processing searchBooksByPublisherRequest with argument: ", request.getSearch());

		this.bookService.findByPublisherNameContaining(request.getSearch()).forEach(book -> {
			response.getBooks().add(book);
			log.info("-> found: ", book.getName());
		});

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchBooksByTagRequest")
	@ResponsePayload
	public SearchBooksResponse searchBooksByTagName(@RequestPayload SearchBooksByTagRequest request) {
		SearchBooksResponse response = new SearchBooksResponse();
		log.info("processing searchBooksByTagRequest with argument: ", request.getSearch());

		this.bookService.findByTagValueContaining(request.getSearch()).forEach(book -> {
			response.getBooks().add(book);
			log.info("-> found: ", book.getName());
		});

		return response;
	}
}
