package io.ab.library.webapp.client.impl;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.AccountClient;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignInRequest;
import io.ab.library.webapp.wsdl.SignInResponse;
import io.ab.library.webapp.wsdl.SignUpForm;
import io.ab.library.webapp.wsdl.SignUpRequest;

@Component
public class AccountClientSoap extends AbstractClientSoap implements AccountClient {

	public AccountClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}

	public Account signIn(SignInForm form) {
		logger.debug("processing signIn with input: " + form.getEmail() + " " + form.getPassword());
		SignInRequest request = new SignInRequest();
		request.setSignInForm(form);

		SignInResponse response = (SignInResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}

	public Account signUp(SignUpForm form) {
		SignUpRequest request = new SignUpRequest();
		request.setSignUpForm(form);

		SignInResponse response = (SignInResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}

}
