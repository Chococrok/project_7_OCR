package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Book;

public interface BookClient {

	public List<Book> getAllBooks();
	public List<Book> searchBooksByBookName(String search);
	public List<Book> searchBooksByAuthorName(String search);
	public List<Book> searchBooksByPublisherName(String search);
	public List<Book> searchBooksByTagName(String search);
}
