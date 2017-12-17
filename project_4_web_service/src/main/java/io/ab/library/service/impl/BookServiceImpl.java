package io.ab.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Book;
import io.ab.library.repository.BookRepository;
import io.ab.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Iterable<Book> getAll() {
		return this.bookRepository.findAll();
	}

}
