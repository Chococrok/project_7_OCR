package io.ab.library.webapp.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.client.impl.AbstractClientSoap;
import io.ab.library.webapp.service.AuthorService;
import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.Book;

public abstract class LibraryActionSupport extends ActionSupport {
	
	protected static final Logger log = LoggerFactory.getLogger(AbstractClientSoap.class);
	
	protected List<Author> authors;
	protected List<Book> books;
	
	@Autowired
	protected AuthorService authorService;
	@Autowired
	protected BookService bookService;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
