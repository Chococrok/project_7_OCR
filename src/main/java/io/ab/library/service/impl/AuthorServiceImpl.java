package io.ab.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Author;
import io.ab.library.repository.AuthorRepository;
import io.ab.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Iterable<Author> getAll() {
		return this.authorRepository.findAll();
	}

	@Override
	public Author getOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
