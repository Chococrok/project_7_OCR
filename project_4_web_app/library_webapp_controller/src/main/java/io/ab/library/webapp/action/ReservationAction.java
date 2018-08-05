package io.ab.library.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.service.pojo.BookPOJO;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.Rental;
import io.ab.library.webapp.wsdl.Reservation;

@Controller
@InterceptorRef("loginStack")
@Result(type = "redirectAction", location = "user")
public class ReservationAction extends LibraryActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	private int bookId;
			
	@Override
	public String execute() throws Exception {
		int accountId = ((Account) session.get("account")).getId();
		this.reservationService.addReservation(accountId, bookId);
		
		return SUCCESS;
	}
	
	@Action("reservation/delete")
	public String deleteReservation() {
		int accountId = ((Account) session.get("account")).getId();
		this.reservationService.deleteReservation(accountId, bookId);
		
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
