package io.ab.library.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.wsdl.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public List<Book> searchBooksByBookName(String search);
	public List<Book> searchBooksByAuthorName(String search);
	public List<Book> searchBooksByPublisherName(String search);
	public List<Book> searchBooksByTagName(String search);

}
