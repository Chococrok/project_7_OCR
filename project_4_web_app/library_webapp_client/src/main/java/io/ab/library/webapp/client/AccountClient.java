package io.ab.library.webapp.client;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;

public interface AccountClient {

	Account signIn(SignInForm form);
}
