package io.ab.library.webapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import io.ab.library.webapp.wsdl.Account;
import io.ab.library.webapp.wsdl.SignInForm;

@Result(name="success", location="home", type="redirect")
public class LogoutAction extends LibraryActionSupport implements SessionAware {
			
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		session.clear();
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}
}
