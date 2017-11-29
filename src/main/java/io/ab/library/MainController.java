package io.ab.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.ab.library.Account;
import io.ab.library.AccountRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/account") // This means URL's start with /account (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private AccountRepository accountRepository;
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private BookRepository bookRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody void addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Account> getAllUsers() {
		// This returns a JSON or XML with the users
		return accountRepository.findAll();
	}
	
	@GetMapping(path="/book/all")
	public @ResponseBody Iterable<Book> getAllBooks() {
		// This returns a JSON or XML with the users
		return bookRepository.findAll();
	}
}
