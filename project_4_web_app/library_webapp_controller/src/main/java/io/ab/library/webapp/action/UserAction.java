package io.ab.library.webapp.action;

import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;

@Controller
public class UserAction extends LibraryActionSupport {
			
	@Override
	public String execute() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.getAllBooks());
		this.page = "user";
		return SUCCESS;
	}
}
