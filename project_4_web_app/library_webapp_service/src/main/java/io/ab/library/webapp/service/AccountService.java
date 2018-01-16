package io.ab.library.webapp.service;

import java.util.List;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignUpForm;

import org.springframework.stereotype.Service;

public interface AccountService {
	
	public Account signIn(SignInForm form);
	public Account signUp(SignUpForm form);

}
