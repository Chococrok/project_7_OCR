package io.ab.library.controller.soap;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.ab.library.controller.soap.request.SignInRequest;
import io.ab.library.controller.soap.request.SignUpRequest;
import io.ab.library.controller.soap.request.UpdateAccountRequest;
import io.ab.library.controller.soap.response.GetAllAuthorsResponse;
import io.ab.library.controller.soap.response.AccountResponse;
import io.ab.library.service.AccountService;

@Endpoint
public class AccountEndpoint {
	private static final String NAMESPACE_URI = "http://ab.io/library";

	@Autowired
	private AccountService accountService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAccountsRequest")
	@ResponsePayload
	public GetAllAuthorsResponse getAllAuthors() {
		GetAllAuthorsResponse response = new GetAllAuthorsResponse();
		System.out.println("processing author request");

		// this.authorService.getAllAuthors().forEach(author -> {
		// response.getAuthors().add(author);
		// });

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "signInRequest")
	@ResponsePayload
	public AccountResponse signIn(@RequestPayload SignInRequest request) throws SOAPException, SOAPFaultException {
		AccountResponse response = new AccountResponse();
		System.out.println("processing signInRequest");

		response.setAccount(this.accountService.signIn(request.getSignInForm()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "signUpRequest")
	@ResponsePayload
	public AccountResponse signUp(@RequestPayload SignUpRequest request) throws SOAPFaultException, SOAPException {
		AccountResponse response = new AccountResponse();
		System.out.println("processing signUpRequest");

		response.setAccount(this.accountService.signUp(request.getSignUpForm()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAccountRequest")
	@ResponsePayload
	public AccountResponse signUp(@RequestPayload UpdateAccountRequest
			request) throws SOAPFaultException, SOAPException {
		AccountResponse response = new AccountResponse();
		System.out.println("processing AccountUpdate for user: " + request.getAccount().getEmail());

		response.setAccount(this.accountService.update(request.getAccount()));
		return response;
	}
}
