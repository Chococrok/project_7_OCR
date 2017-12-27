package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;

import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService {
	
	public Account signIn(SignInForm form){
		return this.accountClient.signIn(form);
	}

}
