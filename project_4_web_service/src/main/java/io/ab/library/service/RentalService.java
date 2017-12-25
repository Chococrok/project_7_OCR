package io.ab.library.service;

import java.util.List;

import io.ab.library.model.Book;

public interface RentalService {

	public Iterable<Book> addRentalsToBooks(Iterable<Book> iterable);
}
