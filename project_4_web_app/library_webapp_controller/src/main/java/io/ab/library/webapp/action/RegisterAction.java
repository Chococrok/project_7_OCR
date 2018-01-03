package io.ab.library.webapp.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import io.ab.library.webapp.wsdl.SignUpForm;

@Result(name="input", location="register.jsp")
public class RegisterAction extends LibraryActionSupport implements SessionAware {

	private SignUpForm signUpForm;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Action(value = "register/submit", results = { @Result(location = "user", type = "redirectAction") })
	public String register() throws Exception {
		this.session.put("account", this.accountService.signUp(signUpForm));
		return SUCCESS;
	}

	@Override
	public void validate() {
		try {
			if (signUpForm.getEmail().isEmpty() || signUpForm.getFirstName().isEmpty()
					|| signUpForm.getPassword().isEmpty() || signUpForm.getCheckPassword().isEmpty()) {
				this.addActionError("Tout les champs doivent être rensigné, à l'exception du numéro de téléphone.");
			}
			if (!signUpForm.getCheckPassword().equals(signUpForm.getPassword())) {
				this.addActionError("Les deux mot de passes ne correspondent pas.");
			}
		} catch (NullPointerException e) {
			this.addActionError("Tout les champs doivent être rensigné, à l'exception du numéro de téléphone.");
		}
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
