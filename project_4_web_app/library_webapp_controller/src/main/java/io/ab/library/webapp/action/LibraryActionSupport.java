package io.ab.library.webapp.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.service.*;
import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.utils.DateUtils;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;

public abstract class LibraryActionSupport extends ActionSupport {
	
	public static final String ACCOUNT = "account";
		
	protected List<Author> authors;
	protected List<BookPOJO> books;
	protected List<Rental> rentals;
	protected List<Reservation> reservations;
	
	protected String page;
	
	@Autowired
	protected AuthorService authorService;
	@Autowired
	protected BookService bookService;
	@Autowired
	protected AccountService accountService;
	@Autowired
	protected RentalService rentalService;
	@Autowired
	protected ReservationService reservationService;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookPOJO> getBooks() {
		return books;
	}

	public void setBooks(List<BookPOJO> books) {
		this.books = books;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	// Utils methodes
	public String formatDate(Date date) {
		return DateUtils.format(date);
	}
	
}
