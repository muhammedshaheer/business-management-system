package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.service.UserService;
import com.bms.service.UserServiceImpl;

public class ResetPasswordAction extends AbstractAction{

	private static final String NEXT_PAGE = "login.jsp";
	
	public String execute(HttpServletRequest request, HttpServletResponse response){
	
		System.out.println("In reset password.java");
		
		String password = request.getParameter("password");
		
		System.out.println("In reset password.java : password" + password);
		
		String confirmPassword = request.getParameter("confirmpassword");
		
		if(password.equals(confirmPassword)){
			
			UserService userService = new UserServiceImpl();
			
			userService.updatePassword(request.getParameter("username"), password);
		}
		
		else{
			
			throw new RuntimeException();
		}
		
		//request.getRequestDispatcher("login.jsp");
		return NEXT_PAGE;
	}

}  