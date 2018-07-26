package io.ab.library.service.impl;

import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ab.library.controller.soap.BookEndpoint;
import io.ab.library.controller.soap.dto.SignInForm;
import io.ab.library.controller.soap.dto.SignUpForm;
import io.ab.library.model.Account;
import io.ab.library.repository.AccountRepository;
import io.ab.library.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private FaultServiceImpl faultService;

	@Override
	public Account signIn(SignInForm form) throws SOAPException, SOAPFaultException {
		Account account = this.accountRepository.findByEmailIs(form.getEmail());
		if (account == null) {
			this.faultService.sendNewClientSoapFault("Aucun utilisateur avec cette email");
		}

		if (this.accountRepository.checkPassword(form.getEmail(), form.getPassword())) {
			return account;
		}
		
		this.faultService.sendNewClientSoapFault("Mauvais mot de passe");
		return null;
	}

	@Override
	public Account signUp(SignUpForm form) throws SOAPFaultException, SOAPException {
		if(form.getEmail() == null 
				|| form.getFirstName() == null 
				|| form.getLastName() == null
				|| form.getPassword() == null
				|| form.getCheckPassword() == null) {
			this.faultService.sendNewClientSoapFault("Complétez tout les champs.");
		}
		
		if(!form.getPassword().equals(form.getCheckPassword())) {
			this.faultService.sendNewClientSoapFault("Le deux mot de passe ne correspondent pas.");
		}
		
		if(this.accountRepository.findByEmailIs(form.getEmail()) != null) {
			this.faultService.sendNewClientSoapFault("Un utilisateur avec cette email existe déjà.");
		}
		
		Account account = new Account();
		account.setEmail(form.getEmail());
		account.setFirstName(form.getFirstName());
		account.setLastName(form.getLastName());
		account.setPassword(form.getPassword());
		account.setPhoneNumber(form.getPhone());		
		
		return this.accountRepository.save(account);
	}

}
