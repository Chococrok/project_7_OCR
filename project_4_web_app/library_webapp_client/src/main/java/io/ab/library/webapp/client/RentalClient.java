package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Book;
import io.ab.library.webapp.wsdl.Rental;

public interface RentalClient {

	public List<Rental> getRentalsByUser(int id);
	public Rental updateRental(Rental rental);
}
