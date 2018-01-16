package io.ab.library.webapp.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import io.ab.library.webapp.client.AccountClient;
import io.ab.library.webapp.client.AuthorClient;
import io.ab.library.webapp.client.BookClient;
import io.ab.library.webapp.client.RentalClient;
import io.ab.library.webapp.client.TagClient;

public class AbstractService {
	
	protected final static Logger logger = LogManager.getRootLogger();
	
	@Autowired
	protected AuthorClient authorClient;
	@Autowired
	protected BookClient bookClient;
	@Autowired
	protected TagClient tagClient;
	@Autowired
	protected AccountClient accountClient;
	@Autowired
	protected RentalClient rentalClient;
	
}
