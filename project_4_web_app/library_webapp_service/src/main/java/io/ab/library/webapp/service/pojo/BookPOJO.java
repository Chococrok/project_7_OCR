package io.ab.library.webapp.service.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.ab.library.webapp.utils.DateUtils;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;

public class BookPOJO extends Book {
	
	private boolean available;
	private int availableCopy;
	private Date backDate;
	private boolean maxReservationReached;
	private boolean rentedByCurrentUser;
	private boolean bookedByCurrentUser;
	
	public BookPOJO(Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.copy = book.getCopy();
		this.author = book.getAuthor();
		this.publisher = book.getPublisher();
		this.rentals = book.getRentals();
		this.reservations = book.getReservations();
		this.tags = book.getTags();
		
		this.available = this.rentals.size() < this.copy;
		this.availableCopy = this.copy - this.rentals.size();
		
		if (!this.available) {
			for (Rental rental : this.rentals) {
				Date date = rental.getDeadLine().toGregorianCalendar().getTime();
				
				if(backDate == null || backDate.before(date)) {
					backDate = date;
				}
			}
			
			this.maxReservationReached = this.reservations.size() >= this.copy * 2;
		}
		
	}

	public boolean getAvailable() {
		return available;
	}
	
	public int getAvailableCopy() {
		return availableCopy;
	}

	public Date getBackDate() {
		return this.backDate;
	}
	
	public String getFormattedBackDate() {
		return DateUtils.format(this.backDate);
	}
	
	public boolean getmaxReservationReached() {
		return this.maxReservationReached;
	}

	public boolean getRentedByCurrentUser() {
		return rentedByCurrentUser;
	}

	public void setRentedByCurrentUser(boolean rentedByCurrentUser) {
		this.rentedByCurrentUser = rentedByCurrentUser;
	}

	public boolean getBookedByCurrentUser() {
		return bookedByCurrentUser;
	}

	public void setBookedByCurrentUser(boolean bookedByCurrentUser) {
		this.bookedByCurrentUser = bookedByCurrentUser;
	}
	
	
}
