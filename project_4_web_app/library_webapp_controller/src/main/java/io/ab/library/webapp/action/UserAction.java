package io.ab.library.webapp.action;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import io.ab.library.webapp.dto.BookDTO;

@Controller
@ParentPackage(value ="loginPackage")
@InterceptorRef("loginStack")
public class UserAction extends LibraryActionSupport {
			
	@Override
	public String execute() throws Exception {
		this.books = BookDTO.listConverter(this.bookService.getAllBooks());
		this.page = "user";
		return SUCCESS;
	}
}
