package io.ab.library.service;

import org.springframework.stereotype.Service;

import io.ab.library.model.Tag;

public interface TagService {

	Iterable<Tag> findAll();
}
