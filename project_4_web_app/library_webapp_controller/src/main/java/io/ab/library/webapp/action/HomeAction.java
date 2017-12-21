package io.ab.library.webapp.action;

import org.springframework.stereotype.Controller;

@Controller
public class HomeAction extends LibraryActionSupport {
		
	@Override
	public String execute() throws Exception {
		this.books = this.bookService.getBooks();
		return SUCCESS;
	}
}
