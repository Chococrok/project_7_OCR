package io.ab.library.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.wsdl.Tag;

@Service
public class TagService extends AbstractService{

	public List<Tag> getAllTags() {
		return this.tagClient.getAllTags();
	}

}
