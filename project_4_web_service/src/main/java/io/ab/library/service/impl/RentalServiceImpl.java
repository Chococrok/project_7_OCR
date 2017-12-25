package io.ab.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Book;
import io.ab.library.repository.RentalRepository;
import io.ab.library.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {
	
	@Autowired
	private RentalRepository rentalRepository;
	
	public Iterable<Book> addRentalsToBooks(Iterable<Book> books) {
		books.forEach(book -> {
			try {
				book.setRentals(this.rentalRepository.findAllByBook(book));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return books;
	}

}
