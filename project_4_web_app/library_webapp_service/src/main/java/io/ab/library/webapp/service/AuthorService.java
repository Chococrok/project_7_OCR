package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.wsdl.Author;
import org.springframework.stereotype.Service;

public interface AuthorService {
	
	public List<Author> getAuthors();

}
