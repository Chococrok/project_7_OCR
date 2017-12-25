package io.ab.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.model.Tag;
import io.ab.library.repository.TagRepository;
import io.ab.library.service.TagService;

@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	TagRepository tagRepository;

	@Override
	public Iterable<Tag> findAll() {
		return this.tagRepository.findAll();
	}

}
