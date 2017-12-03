package io.ab.library.service;

import io.ab.library.model.Author;

public interface AuthorService {
	
	Author getOne();
	Iterable<Author> getAll();

}
