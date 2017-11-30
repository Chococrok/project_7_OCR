package io.ab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.ab.library.model.Tag;
import io.ab.library.repository.TagRepository;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	TagRepository publisherRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Tag> getAllPublishers() {
		return this.publisherRepository.findAll();
	}

}
