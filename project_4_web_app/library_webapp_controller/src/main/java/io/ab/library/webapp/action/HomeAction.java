package io.ab.library.webapp.action;

import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;

@Controller
public class HomeAction extends LibraryActionSupport {
			
	@Override
	public String execute() throws Exception {
		this.books = BookDTO.toDtos(this.bookService.getAllBooks());
		this.page = "home";
		return SUCCESS;
	}
}
