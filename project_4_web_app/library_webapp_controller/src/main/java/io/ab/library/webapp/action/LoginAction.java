package io.ab.library.webapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;

public class LoginAction extends LibraryActionSupport implements SessionAware {
	
	private static final String ACCOUNT = "account";
		
	private SignInForm signInForm;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Action("login/submit")
	public String login() throws Exception {
		Account account = this.accountService.signIn(signInForm);
		this.session.put(ACCOUNT, account);
		return SUCCESS;
	}

	@Override
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
