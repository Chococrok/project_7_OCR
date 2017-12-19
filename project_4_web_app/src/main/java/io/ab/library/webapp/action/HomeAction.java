package io.ab.library.webapp.action;

import java.util.ArrayList;
import java.util.List;


import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.wsdl.Author;

public class HomeAction extends LibraryActionSupport {
	
	private List<Author> authors;
	
	@Override
	public String execute() throws Exception {
		this.authors = this.authorService.getAuthors();
		return SUCCESS;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
