package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.wsdl.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractService {
	
	public List<Author> getAuthors(){
		return this.authorClient.getAllAuthors();
	}

}
