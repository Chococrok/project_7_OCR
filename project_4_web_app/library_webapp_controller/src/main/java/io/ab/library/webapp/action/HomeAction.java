package io.ab.library.webapp.action;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.wsdl.Account;

import java.util.Map;

@Controller
public class HomeAction extends LibraryActionSupport implements SessionAware {
	
	private Map<String, Object> session;
	public Map<Integer, Boolean> bookedByUser; 
			
	@Override
	public String execute() throws Exception {
		this.books = this.bookService.modelsToPOJOs(this.bookService.getAllBooks());

		Account account = (Account) session.get("account");
		
		if (account != null) {
			this.rentals = this.rentalService.getRentalsByUser(account.getId());
			this.bookService.checkBookedByUser(this.books, account);
			this.bookService.checkRentedByUser(this.books, account);
		}
		
		this.page = "home";
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
