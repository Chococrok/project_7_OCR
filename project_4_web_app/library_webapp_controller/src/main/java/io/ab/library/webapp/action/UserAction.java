package io.ab.library.webapp.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.utils.DateUtils;

@Controller
@InterceptorRef("loginStack")
public class UserAction extends LibraryActionSupport implements SessionAware {
	
	private Map<String, Object> session;
			
	@Override
	public String execute() throws Exception {
		Account account = (Account) session.get("account");
		this.rentals = this.rentalService.getRentalsByUser(account.getId());
		this.reservations = this.reservationService.findAllReservationByAccount(account.getId());
		this.page = "user";
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String formatDate(Date date) {
		return DateUtils.format(date);
	}
}
