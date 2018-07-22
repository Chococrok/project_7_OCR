package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.wsdl.Rental;

public interface RentalService  {
	
	public List<Rental> getRentalsByUser(int id);
	public Rental extendRental(int accountId, int bookId, int durationInWeek);
}
