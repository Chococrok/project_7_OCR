package io.ab.library.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Rental;

@Controller
@ParentPackage(value ="loginPackage")
@InterceptorRef("loginStack")
public class UserAction extends LibraryActionSupport implements SessionAware {
	
	private List<Rental> rentals;
	private Map<String, Object> session;
			
	@Override
	public String execute() throws Exception {
		this.rentals = this.rentalService.getRentalsByUser(((Account) session.get("account")).getId());
		this.page = "user";
		return SUCCESS;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
