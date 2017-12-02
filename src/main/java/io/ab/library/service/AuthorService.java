package io.ab.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Author;
import io.ab.library.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Iterable<Author> getAllAuthors() {
		return this.authorRepository.findAll();
	}

}
