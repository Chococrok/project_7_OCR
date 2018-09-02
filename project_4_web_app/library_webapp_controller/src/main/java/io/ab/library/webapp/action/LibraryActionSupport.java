package io.ab.library.webapp.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

import io.ab.library.webapp.service.*;
import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.service.pojo.ReservationPOJO;
import io.ab.library.webapp.utils.DateUtils;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Author;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;

public abstract class LibraryActionSupport extends ActionSupport implements SessionAware, ParameterNameAware {

	public static final String ACCOUNT = "account";
	public static final String ERROR = "error";
	
	protected Map<String, Object> session;

	protected List<Author> authors;
	protected List<BookPOJO> books;
	protected List<Rental> rentals;
	protected List<ReservationPOJO> reservationPOJOs;

	protected String error;

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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public boolean acceptableParameterName(String parameterName) {
		boolean allowedParameterName = true ;

	    if ( parameterName.contains("session")  || parameterName.contains("request") ) {
	        allowedParameterName = false ;
	    } 

	    return allowedParameterName;
	}

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

	public List<ReservationPOJO> getReservations() {
		return reservationPOJOs;
	}

	public void setReservations(List<ReservationPOJO> reservationPOJOs) {
		this.reservationPOJOs = reservationPOJOs;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getError() {
		return error;
	}

	// Utils methodes
	public String formatDate(Date date) {
		return DateUtils.format(date);
	}

}
