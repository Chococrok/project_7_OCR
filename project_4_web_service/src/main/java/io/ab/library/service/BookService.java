package io.ab.library.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import io.ab.library.model.Book;

public interface BookService {

	Iterable<Book> getAll();
	Iterable<Book> getAllWithRentals();
	List<Book> findByNameContaining(String name);
	List<Book> findByAuthorFirstNameOrLastNameContaining(String name);
	List<Book> findByPublisherNameContaining(String name);
	List<Book> findByTagValueContaining(String value);
	boolean isAvailable(Integer bookId);
}
