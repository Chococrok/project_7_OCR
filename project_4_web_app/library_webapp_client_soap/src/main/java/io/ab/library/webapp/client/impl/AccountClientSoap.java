package io.ab.library.webapp.client.impl;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import io.ab.library.webapp.client.AccountClient;
import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.AccountResponse;
import io.ab.library.webapp.wsdl.FindOneAccountRequest;
import io.ab.library.webapp.wsdl.ObjectFactory;
import io.ab.library.webapp.wsdl.SignInForm;
import io.ab.library.webapp.wsdl.SignInRequest;
import io.ab.library.webapp.wsdl.AccountResponse;
import io.ab.library.webapp.wsdl.SignUpForm;
import io.ab.library.webapp.wsdl.SignUpRequest;
import io.ab.library.webapp.wsdl.UpdateAccountRequest;

@Component
public class AccountClientSoap extends AbstractClientSoap implements AccountClient {

	public AccountClientSoap(ObjectFactory objectFactory, Jaxb2Marshaller marshaller) {
		super(objectFactory, marshaller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Account findOne(int id) {
		logger.debug("processing findOne account);");
		FindOneAccountRequest request = new FindOneAccountRequest();
		request.setAccountId(id);
		
		AccountResponse response = (AccountResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}

	@Override
	public Account signIn(SignInForm form) {
		logger.debug("processing signIn with input: " + form.getEmail() + " " + form.getPassword());
		SignInRequest request = new SignInRequest();
		request.setSignInForm(form);

		AccountResponse response = (AccountResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}

	@Override
	public Account signUp(SignUpForm form) {
		SignUpRequest request = new SignUpRequest();
		request.setSignUpForm(form);

		AccountResponse response = (AccountResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}
	
	@Override
	public Account update(Account account) {
		UpdateAccountRequest request = new UpdateAccountRequest();
		request.setAccount(account);

		AccountResponse response = (AccountResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		return response.getAccount();
	}

}
