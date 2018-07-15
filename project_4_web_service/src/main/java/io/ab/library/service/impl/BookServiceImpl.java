package io.ab.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ab.library.model.Book;
import io.ab.library.repository.BookRepository;
import io.ab.library.repository.RentalRepository;
import io.ab.library.service.BookService;
import io.ab.library.service.RentalService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private RentalService rentalService;

	@Override
	public Iterable<Book> getAll() {
		return this.bookRepository.findAll();
	}
	
	@Override
	public Iterable<Book> getAllWithRentals() {
		return this.rentalService.addRentalsToBooks(this.bookRepository.findAll());
	}

	@Override
	public List<Book> findByNameContaining(String name) {
		return (List<Book>) this.rentalService
				.addRentalsToBooks(this.bookRepository.findByNameContainingIgnoreCase(name));
	}

	@Override
	public List<Book> findByAuthorFirstNameOrLastNameContaining(String name) {
		List<Book> books = null;
		try {
			books = (List<Book>) this.rentalService
					.addRentalsToBooks(this.bookRepository.findByAuthorFirstNameOrLastNameContaining(name));
			this.bookRepository.findByAuthorFirstNameOrLastNameContaining(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> findByPublisherNameContaining(String name) {
		List<Book> books = null;
		try {
			books = (List<Book>) this.rentalService
					.addRentalsToBooks(this.bookRepository.findByPublisherNameContaining(name));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> findByTagValueContaining(String value) {
		List<Book> books = null;
		try {
			books = (List<Book>) this.rentalService
					.addRentalsToBooks(this.bookRepository.findByTagValueContaining(value));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	@Override
	public boolean isAvailable(Integer bookId) {
		return this.bookRepository.isAvailable(bookId);
	}

}
