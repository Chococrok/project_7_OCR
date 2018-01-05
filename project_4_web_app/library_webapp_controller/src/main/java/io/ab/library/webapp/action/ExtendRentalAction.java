package io.ab.library.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Rental;

@Controller
@Result(type = "redirectAction", location = "user")
public class ExtendRentalAction extends LibraryActionSupport {

	private Rental rental;
	private int durationInWeek;

	@Override
	public String execute() throws Exception {
		this.rentalService.extendRental(rental.getId().getAccountId(), rental.getId().getBookId(), durationInWeek);
		return SUCCESS;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public int getDurationInWeek() {
		return durationInWeek;
	}

	public void setDurationInWeek(int durationInWeek) {
		this.durationInWeek = durationInWeek;
	}

}
