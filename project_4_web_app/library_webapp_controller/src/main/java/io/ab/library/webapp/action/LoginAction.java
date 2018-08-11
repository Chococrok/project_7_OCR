package io.ab.library.webapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.ws.soap.client.SoapFaultClientException;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;

public class LoginAction extends LibraryActionSupport implements SessionAware {
			
	private SignInForm signInForm;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Action(value="login/submit", results= {
			@Result(name = LibraryActionSupport.SUCCESS, location = "user", type = "redirect"),
			@Result(name = LibraryActionSupport.ERROR, location = "login.jsp")
	})
	public String login() throws Exception {
		try {
			Account account = this.accountService.signIn(signInForm);			
			this.session.put(ACCOUNT, account);
		} catch (SoapFaultClientException e) {
			System.out.println(e);
			this.error = e.getFaultStringOrReason();
			return ERROR;
		}
		
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public SignInForm getSignInForm() {
		return signInForm;
	}

	public void setSignInForm(SignInForm signInForm) {
		this.signInForm = signInForm;
	}

}
