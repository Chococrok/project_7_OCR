package io.ab.library.webapp.interceptor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import io.ab.library.webapp.service.TagService;

public class SearchParamInterceptor extends AbstractInterceptor {
	
	@Autowired
	private TagService tagService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.getInvocationContext().getValueStack().set("tags", tagService.getAllTags());
		return invocation.invoke();
	}

}
