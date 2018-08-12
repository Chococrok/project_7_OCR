package io.ab.library.webapp.action;

import org.springframework.stereotype.Controller;

import io.ab.library.webapp.wsdl.Account;

@Controller
public class HomeAction extends LibraryActionSupport {
				
	@Override
	public String execute() throws Exception {
		this.books = this.bookService.modelsToPOJOs(this.bookService.getAllBooks());

		Account account = (Account) super.session.get("account");
		
		if (account != null) {
			this.rentals = this.rentalService.getRentalsByUser(account.getId());
			this.bookService.checkBookedByUser(this.books, account);
			this.bookService.checkRentedByUser(this.books, account);
		}
		
		this.page = "home";
		return SUCCESS;
	}
}
