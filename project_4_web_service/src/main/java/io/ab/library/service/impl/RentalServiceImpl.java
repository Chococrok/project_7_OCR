package io.ab.library.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Account;
import io.ab.library.model.Book;
import io.ab.library.model.Rental;
import io.ab.library.model.RentalPK;
import io.ab.library.repository.RentalRepository;
import io.ab.library.service.RentalService;
import io.ab.library.service.ReservationService;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	
	@Override
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

	public Iterable<Rental> findByUser(int id) {
		Account account = new Account();
		account.setId(id);
		Iterable<Rental> rentals = new ArrayList<Rental>();
		
		try {
			rentals = this.rentalRepository.findAllByAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.checkDeadLine(rentals);
	}

	public Rental update(Rental rental) {
		return this.rentalRepository.save(rental);
	}

	@Override
	public Iterable<Rental> findAll() {
		return this.checkDeadLine(this.rentalRepository.findAll());
	}

	@Override
	public Rental findOne(int accountId, int bookId) {
		RentalPK key = new RentalPK(accountId, bookId);
		return this.checkDeadLine(this.rentalRepository.findOne(key));
	}
	
	@Override
	public boolean exists(int accountId, int bookId) {
		RentalPK key = new RentalPK(accountId, bookId);
		return this.rentalRepository.exists(key);
	}
	
	@Override
	public void deleteOne(int accountId, int bookId) {
		RentalPK key = new RentalPK(accountId, bookId);
		this.rentalRepository.delete(key);
	}
	
	private Iterable<Rental> checkDeadLine(Iterable<Rental> rentals) {		
		rentals.forEach(rental -> {
			boolean over = rental.getDeadLine().before(new Date());
			rental.setRentalOver(over);		
		});
		
		return rentals;
	}
	
	private Rental checkDeadLine(Rental rental) {
		if(rental != null) {
			boolean over = rental.getDeadLine().before(new Date());
			rental.setRentalOver(over);			
		}
		
		return rental;
	}

}
