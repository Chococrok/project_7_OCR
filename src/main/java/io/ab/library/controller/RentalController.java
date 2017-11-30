package io.ab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.ab.library.model.Rental;
import io.ab.library.repository.RentalRepository;

@Controller
@RequestMapping("/rental")
public class RentalController {
	
	@Autowired
	RentalRepository rentalRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Rental> getAllPublishers() {
		return this.rentalRepository.findAll();
	}

}
