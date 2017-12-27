package io.ab.library.service;

import io.ab.library.controller.soap.dto.SignInForm;
import io.ab.library.controller.soap.dto.SignUpForm;
import io.ab.library.model.Account;

public interface AccountService {
	
	Account signIn(SignInForm form);
	Account signUp(SignUpForm form);

}
