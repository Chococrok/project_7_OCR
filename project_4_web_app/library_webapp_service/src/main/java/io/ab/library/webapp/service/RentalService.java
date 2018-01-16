package io.ab.library.webapp.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.ab.library.webapp.wsdl.Rental;

import org.springframework.stereotype.Service;

public interface RentalService  {
	
	public List<Rental> getRentalsByUser(int id);
	public Rental extendRental(int accountId, int bookId, int durationInWeek);
}
