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
import io.ab.library.util.FaultThrower;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account findOne(int id) {
		return this.accountRepository.findOne(id);
	}

	@Override
	public Account signIn(SignInForm form) throws SOAPException, SOAPFaultException {
		Account account = this.accountRepository.findByEmailIs(form.getEmail());
		if (account == null) {
			FaultThrower.sendNewClientSoapFault("Aucun utilisateur avec cette email");
		}

		if (this.accountRepository.checkPassword(form.getEmail(), form.getPassword())) {
			return account;
		}
		
		FaultThrower.sendNewClientSoapFault("Mauvais mot de passe");
		return null;
	}

	@Override
	public Account signUp(SignUpForm form) throws SOAPFaultException, SOAPException {
		if(form.getEmail() == null 
				|| form.getFirstName() == null 
				|| form.getLastName() == null
				|| form.getPassword() == null
				|| form.getCheckPassword() == null) {
			FaultThrower.sendNewClientSoapFault("Complétez tout les champs.");
		}
		
		if(!form.getPassword().equals(form.getCheckPassword())) {
			FaultThrower.sendNewClientSoapFault("Le deux mot de passe ne correspondent pas.");
		}
		
		if(this.accountRepository.findByEmailIs(form.getEmail()) != null) {
			FaultThrower.sendNewClientSoapFault("Un utilisateur avec cette email existe déjà.");
		}
		
		Account account = new Account();
		account.setEmail(form.getEmail());
		account.setFirstName(form.getFirstName());
		account.setLastName(form.getLastName());
		account.setPassword(form.getPassword());
		account.setPhoneNumber(form.getPhone());		
		
		return this.accountRepository.save(account);
	}
	
	@Override
	public Account update(Account account) throws SOAPFaultException, SOAPException {
		Account existingAccount = this.accountRepository.findOne(account.getId());
		
		if(existingAccount == null) {
			FaultThrower.sendNewClientSoapFault("Trying to update a new user. please sign up first");
		}
		
		account.setPassword(existingAccount.getPassword());
		
		return this.accountRepository.save(account);
	}

}
