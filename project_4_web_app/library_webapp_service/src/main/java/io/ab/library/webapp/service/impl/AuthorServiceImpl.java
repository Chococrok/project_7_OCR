package io.ab.library.webapp.service.impl;

import java.util.List;

import io.ab.library.webapp.service.AuthorService;
import io.ab.library.webapp.wsdl.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends AbstractService implements AuthorService {
	
	public List<Author> getAuthors(){
		return this.authorClient.getAllAuthors();
	}

}
