package io.ab.library.webapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import io.ab.library.webapp.wsdl.SignUpForm;

public class RegisterAction extends LibraryActionSupport implements SessionAware {
		
	private SignUpForm signUpForm;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	@Action(value="register/submit", results= {@Result(location="user", type="redirectAction")})
	public String register() throws Exception {
		this.session.put("account", this.accountService.signUp(signUpForm));
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public SignUpForm getSignUpForm() {
		return signUpForm;
	}

	public void setSignUpForm(SignUpForm signUpForm) {
		this.signUpForm = signUpForm;
	}

}
