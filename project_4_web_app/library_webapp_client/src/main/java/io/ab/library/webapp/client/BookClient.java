package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Book;

public interface BookClient {

	public List<Book> getBooks();
}
