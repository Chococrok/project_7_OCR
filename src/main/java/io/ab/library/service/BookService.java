package io.ab.library.service;

import io.ab.library.model.Book;

public interface BookService {

	Iterable<Book> getAll();
}
