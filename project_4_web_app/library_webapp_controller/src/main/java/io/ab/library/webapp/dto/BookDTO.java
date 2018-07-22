package io.ab.library.webapp.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.ab.library.webapp.utils.DateUtils;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;

public class BookDTO extends Book {
	
	private boolean available;
	private int availableCopy;
	private Date backDate;
	private boolean maxReservationReached;
	
	public BookDTO(Book book) {
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
	
	public static List<BookDTO> toDtos(List<Book> books) {
		List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
		for (Book book : books) {
			bookDTOs.add(new BookDTO(book));
		}
		return bookDTOs;
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
}
