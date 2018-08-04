package com.bms.web.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.bms.util.CheckUser;

public class RememberMeAwareFilter extends FormAuthenticationFilter{
	
	private static String ERROR_MESSAGE = "";
	
	private static final String str1 = "<div class=\"align-right col-sm-6\" >";
	
	private static final String str2 =   "<a href=\"forgotPassword.jsp?resent=false\" id=\"forgot\" class=\"forgot\" onclick=\"return confirm('Sent reset link to ";
	
	private static final String str3 = "@gmail.com?')\">Forgot Password?</a></div>";
	
	public RememberMeAwareFilter() {
	
	}
	
	@Override
	protected boolean isRememberMe(ServletRequest request) {
			
		request.setAttribute("errormessage", ERROR_MESSAGE);
		
		return WebUtils.isTrue(request, "rememberMe");
	}
	

	 protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
		 
		 CheckUser checkuser = new CheckUser();
			
			if(checkuser.ifUserExist(request)){
				
			}
			else{
						
				ERROR_MESSAGE = "No such user!<p></p>";
				
		 }

		 String username = request.getParameter("username");
		 
		 String forgotPassword = str1 + str2 +username + str3;	
		 
		// HttpSession session = request.getSession(true);
		 
		 HttpServletRequest req = (HttpServletRequest) request;
		 
		 HttpSession session = req.getSession();
		 
		 //request.setAttribute("username", username);
	
		 session.setAttribute("username", username);
		 
		 ERROR_MESSAGE = forgotPassword + "<p></p>&nbsp;Wrong password!";
		 
		 request.setAttribute("errormessage", ERROR_MESSAGE);	
		 
		 try {
				 
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
		 } catch (ServletException | IOException e1) {
					 
			e1.printStackTrace();
		}
		 
		 return false;

	 }

}
