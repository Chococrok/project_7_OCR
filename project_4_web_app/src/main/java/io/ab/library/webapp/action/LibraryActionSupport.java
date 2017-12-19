package io.ab.library.webapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;

import io.ab.library.webapp.service.AuthorService;

public abstract class LibraryActionSupport extends ActionSupport {
	
	@Autowired
	protected AuthorService authorService;
	
}
