package io.ab.library.webapp.dto;

import java.util.ArrayList;
import java.util.List;

import io.ab.library.webapp.wsdl.Book;

public class BookDTO extends Book {
	
	private boolean available;
	private int availableCopy;
	
	public BookDTO(Book book) {
		this.id = book.getId();
		this.name = book.getName();
		this.copy = book.getCopy();
		this.author = book.getAuthor();
		this.publisher = book.getPublisher();
		this.rentals = book.getRentals();
		this.tags = book.getTags();
		
		this.available = this.rentals.size() < this.copy;
		this.availableCopy = this.copy - this.rentals.size();
	}
	
	public static List<BookDTO> listConverter(List<Book> books) {
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
}
