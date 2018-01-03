package io.ab.library.webapp.service;

import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.Duration;

import io.ab.library.webapp.wsdl.Rental;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

@Service
public class RentalService extends AbstractService {
	
	public List<Rental> getRentalsByUser(int id){
		return this.rentalClient.getRentalsByUser(id);
	}
	
	public Rental extendRental(Rental rental, int durationInWeek){
		rental.getDeadLine().toGregorianCalendar().add(Calendar.WEEK_OF_MONTH, durationInWeek);;
		return this.rentalClient.updateRental(rental);
	}
}
