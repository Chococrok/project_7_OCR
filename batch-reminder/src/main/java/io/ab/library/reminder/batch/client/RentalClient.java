package io.ab.library.reminder.batch.client;

import java.util.List;

import io.ab.library.reminder.batch.wsdl.Rental;

public interface RentalClient {

	public List<Rental> getAllRentals();
}
