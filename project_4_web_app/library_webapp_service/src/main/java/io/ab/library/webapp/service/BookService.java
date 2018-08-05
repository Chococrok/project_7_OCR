package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public List<Book> searchBooksByBookName(String search);
	public List<Book> searchBooksByAuthorName(String search);
	public List<Book> searchBooksByPublisherName(String search);
	public List<Book> searchBooksByTagName(String search);

	List<BookPOJO> modelsToPOJOs(List<Book> books);

	void checkBookedByUser(List<BookPOJO> pojos, Account account);

	void checkRentedByUser(List<BookPOJO> pojos, Account account);

}
