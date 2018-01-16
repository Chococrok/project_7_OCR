package io.ab.library.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.wsdl.Book;

@Service
public class BookServiceImpl extends AbstractService implements BookService {
	
	public List<Book> getAllBooks() {
		return this.bookClient.getAllBooks();
	}
	
	public List<Book> searchBooksByBookName(String search) {
		return this.bookClient.searchBooksByBookName(search);
	}
	public List<Book> searchBooksByAuthorName(String search) {
		return this.bookClient.searchBooksByAuthorName(search);
	}
	public List<Book> searchBooksByPublisherName(String search) {
		return this.bookClient.searchBooksByPublisherName(search);
	}
	public List<Book> searchBooksByTagName(String search) {
		return this.bookClient.searchBooksByTagName(search);
	}

}
