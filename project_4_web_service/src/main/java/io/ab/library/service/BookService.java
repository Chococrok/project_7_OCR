package io.ab.library.service;

import java.util.List;

import io.ab.library.model.Book;

public interface BookService {

    Book findOne(Integer bookId);
    Iterable<Book> getAll();
	Iterable<Book> getAllWithRentals();
	Iterable<Book> getAllWithReservations();
	Iterable<Book> getAllWithRentalsAndReservations();
	List<Book> findByNameContaining(String name);
	List<Book> findByAuthorFirstNameOrLastNameContaining(String name);
	List<Book> findByPublisherNameContaining(String name);
	List<Book> findByTagValueContaining(String value);
	boolean isAvailable(Integer bookId);
}
