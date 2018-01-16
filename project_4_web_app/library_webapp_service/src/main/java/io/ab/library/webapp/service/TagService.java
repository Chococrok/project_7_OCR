package io.ab.library.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ab.library.webapp.wsdl.Tag;

public interface TagService {

	public List<Tag> getAllTags();

}
