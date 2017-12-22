package com.elite.util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*public String intercept(ActionInvocation invacation) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		System.out.println(session.get("userLogin"));
		if(session.get("userLogin") !=null){
			String result = invacation.invoke();
			return result;
		}
		return "login";
	}*/
	
	@Override
	protected String doIntercept(ActionInvocation invacation) throws Exception {
		//String result = invacation.invoke();
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		System.out.println("执行拦截器信息：" + session.get("userLogin"));
		if(session.get("userLogin") !=null){
			String result = invacation.invoke();
			return result;
		}
		return "login";
	}

	
	
}
