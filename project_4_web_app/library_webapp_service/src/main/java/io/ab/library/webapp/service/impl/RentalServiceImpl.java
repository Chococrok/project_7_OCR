package io.ab.library.webapp.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import io.ab.library.webapp.service.RentalService;
import io.ab.library.webapp.wsdl.Rental;

import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl extends AbstractService implements RentalService {
	
	public List<Rental> getRentalsByUser(int id){
		return this.rentalClient.getRentalsByUser(id);
	}
	
	public Rental extendRental(int accountId, int bookId, int durationInWeek){
		Rental rental = this.rentalClient.findOne(accountId, bookId);
		
		if(rental.isExtended()) {
			logger.debug("rental extended = " + rental.isExtended() + " returning");
			return rental;
		}
		
		if(rental.isRentalOver()) {
			logger.debug("rentalOver = " + rental.isRentalOver() + " returning");
			return rental;
		}
		
		GregorianCalendar calendar = rental.getDeadLine().toGregorianCalendar();
		calendar.add(Calendar.WEEK_OF_MONTH, durationInWeek);
		rental.setDeadLine(calendar);
		rental.setExtended(true);
		return this.rentalClient.updateRental(rental);
	}
}
