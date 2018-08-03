package io.ab.library.webapp.client;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignUpForm;

public interface AccountClient {

	Account findOne(int id);
	Account signIn(SignInForm form);
	Account signUp(SignUpForm form);
	Account update(Account account);
}
