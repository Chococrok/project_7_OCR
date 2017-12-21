package io.ab.library.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.wsdl.Book;

@Service
public class BookService extends AbstractService {
	
	public List<Book> getBooks() {
		return this.bookClient.getBooks();
	}

}
