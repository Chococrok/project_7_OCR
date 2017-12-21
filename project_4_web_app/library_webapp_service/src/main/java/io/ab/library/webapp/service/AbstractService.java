package io.ab.library.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.ab.library.webapp.client.AuthorClient;
import io.ab.library.webapp.client.BookClient;

public class AbstractService {
	
	@Autowired
	protected AuthorClient authorClient;
	@Autowired
	protected BookClient bookClient;
	
	protected static final Logger log = LoggerFactory.getLogger(AbstractService.class);

}
