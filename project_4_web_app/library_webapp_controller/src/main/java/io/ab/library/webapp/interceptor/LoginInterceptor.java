package io.ab.library.webapp.interceptor;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	protected final static Logger logger = LogManager.getRootLogger();

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		if(session.get("account") != null) {
			return invocation.invoke();
		}
		logger.debug("user trying to acces  userSpace. redirect on login page");
		return "loginRedirect";
	}

}
