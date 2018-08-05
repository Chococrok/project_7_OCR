package io.ab.library.webapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.service.BookService;
import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;

@Service
public class BookServiceImpl extends AbstractService implements BookService {
	
	@Override
	public List<Book> getAllBooks() {
		return this.bookClient.getAllBooks();
	}
	
	@Override
	public List<Book> searchBooksByBookName(String search) {
		return this.bookClient.searchBooksByBookName(search);
	}
	@Override
	public List<Book> searchBooksByAuthorName(String search) {
		return this.bookClient.searchBooksByAuthorName(search);
	}
	@Override
	public List<Book> searchBooksByPublisherName(String search) {
		return this.bookClient.searchBooksByPublisherName(search);
	}
	@Override
	public List<Book> searchBooksByTagName(String search) {
		return this.bookClient.searchBooksByTagName(search);
	}
	
	@Override
	public List<BookPOJO> modelsToPOJOs(List<Book> books) {
		List<BookPOJO> bookDTOs = new ArrayList<BookPOJO>();
		for (Book book : books) {
			bookDTOs.add(new BookPOJO(book));
		}
		return bookDTOs;
	}
	
	@Override
	public void checkBookedByUser(List<BookPOJO> pojos, Account account) {
		for (BookPOJO pojo : pojos ) {
			for (Reservation reservation : pojo.getReservations()) {
				if (reservation.getId().getAccountId() == account.getId()) {
					pojo.setBookedByCurrentUser(true);
				}
			}
		}
	}
	
	@Override
	public void checkRentedByUser(List<BookPOJO> pojos, Account account) {
		for (BookPOJO pojo : pojos ) {
			for (Rental rental : pojo.getRentals()) {
				if (rental.getId().getAccountId() == account.getId()) {
					pojo.setRentedByCurrentUser(true);
				}
			}
		}
	}

}
