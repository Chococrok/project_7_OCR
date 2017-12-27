package io.ab.library.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import io.ab.library.webapp.client.AccountClient;
import io.ab.library.webapp.client.AuthorClient;
import io.ab.library.webapp.client.BookClient;
import io.ab.library.webapp.client.TagClient;

public class AbstractService {
	
	@Autowired
	protected AuthorClient authorClient;
	@Autowired
	protected BookClient bookClient;
	@Autowired
	protected TagClient tagClient;
	@Autowired
	protected AccountClient accountClient;
	
}
