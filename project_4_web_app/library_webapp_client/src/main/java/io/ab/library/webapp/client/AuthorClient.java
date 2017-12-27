package io.ab.library.webapp.client;

import java.util.List;

import io.ab.library.webapp.wsdl.Author;

public interface AuthorClient {

	public List<Author> getAllAuthors();
}
