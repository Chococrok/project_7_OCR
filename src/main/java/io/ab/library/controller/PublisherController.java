package io.ab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.ab.library.model.Publisher;
import io.ab.library.repository.PublisherRepository;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Publisher> getAllPublishers() {
		return this.publisherRepository.findAll();
	}

}
