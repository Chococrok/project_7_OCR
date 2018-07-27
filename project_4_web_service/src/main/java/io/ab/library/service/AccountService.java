package io.ab.library.service;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

import io.ab.library.controller.soap.dto.SignInForm;
import io.ab.library.controller.soap.dto.SignUpForm;
import io.ab.library.model.Account;

public interface AccountService {
	
	Account signIn(SignInForm form) throws SOAPException, SOAPFaultException;
	Account signUp(SignUpForm form) throws SOAPFaultException, SOAPException;
	Account update(Account account) throws SOAPFaultException, SOAPException;

}
