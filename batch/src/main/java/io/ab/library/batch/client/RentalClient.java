package io.ab.library.batch.client;

import java.util.List;

import io.ab.library.batch.wsdl.Rental;

public interface RentalClient {

	public List<Rental> getAllRentals();
}
