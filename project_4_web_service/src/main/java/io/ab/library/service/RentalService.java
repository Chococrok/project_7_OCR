package io.ab.library.service;

import io.ab.library.model.Book;
import io.ab.library.model.Rental;

public interface RentalService {

	public Iterable<Rental> findAll();
	public Rental findOne(int accountId, int bookId);
	public Iterable<Book> addRentalsToBooks(Iterable<Book> iterable);
	public Iterable<Rental> findByUser(int id);
	public Rental update(Rental rental);
	boolean exists(int accountId, int bookId);
}
