package io.ab.library.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.service.TagService;
import io.ab.library.webapp.wsdl.Tag;

@Service
public class TagServiceImpl extends AbstractService implements TagService {

	public List<Tag> getAllTags() {
		return this.tagClient.getAllTags();
	}

}
