package com.bms.web.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

public class LogoutAction extends LogoutFilter {

	private static final String redirectUrl = "/login.jsp";
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		
		System.out.println("buhuhhhahaah");
		
		Subject currentUser = SecurityUtils.getSubject();

		currentUser.logout(); 
		
		issueRedirect(request, response, redirectUrl);
		
		return false;
		//return super.preHandle(arg0, arg1);
	}
}
