package io.ab.library.webapp.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.dto.BookDTO;
import io.ab.library.webapp.service.AccountService;
import io.ab.library.webapp.service.AuthorService;
import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.Book;

public abstract class LibraryActionSupport extends ActionSupport {
		
	protected List<Author> authors;
	protected List<BookDTO> books;
	
	protected String page;
	
	@Autowired
	protected AuthorService authorService;
	@Autowired
	protected BookService bookService;
	@Autowired
	protected AccountService accountService;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
