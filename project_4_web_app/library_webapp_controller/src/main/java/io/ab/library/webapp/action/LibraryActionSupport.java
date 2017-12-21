package io.ab.library.webapp.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.service.AuthorService;
import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.Book;

public abstract class LibraryActionSupport extends ActionSupport {
		
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
