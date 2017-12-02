package io.ab.library.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.ab.library.model.Author;
import io.ab.library.repository.AuthorRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/author")
public class AuthorRestController {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Author> getAllAuthors() {
		// This returns a JSON or XML with the users
		return authorRepository.findAll();
	}

}
