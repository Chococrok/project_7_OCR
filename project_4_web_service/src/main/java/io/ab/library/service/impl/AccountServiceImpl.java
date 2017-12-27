package io.ab.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.controller.soap.dto.SignInForm;
import io.ab.library.controller.soap.dto.SignUpForm;
import io.ab.library.model.Account;
import io.ab.library.repository.AccountRepository;
import io.ab.library.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account signIn(SignInForm form) {
		Account account = this.accountRepository.findByEmailIs(form.getEmail());
		if (this.accountRepository.checkPassword(form.getEmail(), form.getPassword())) {
			return account;
		}
		return null;
	}

	@Override
	public Account signUp(SignUpForm form) {
		// TODO Auto-generated method stub
		return null;
	}

}
