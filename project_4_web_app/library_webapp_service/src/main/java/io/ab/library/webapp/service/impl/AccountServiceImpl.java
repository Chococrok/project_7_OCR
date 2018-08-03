package io.ab.library.webapp.service.impl;

import java.util.List;

import io.ab.library.webapp.service.AccountService;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignUpForm;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends AbstractService implements AccountService{
	
	@Override
	public Account findOne(int id) {
		return this.accountClient.findOne(id);
	}
	
	@Override
	public Account signIn(SignInForm form){
		return this.accountClient.signIn(form);
	}
	
	@Override
	public Account signUp(SignUpForm form){
		return this.accountClient.signUp(form);
	}

	@Override
	public Account update(Account account) {
		return this.accountClient.update(account);
	}

}
