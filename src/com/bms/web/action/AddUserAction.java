package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;

import com.bms.domain.User;
import com.bms.domain.UserRoles;



public class AddUserAction extends AbstractAction {
	
	private static final int ITERATIONS = 2048;

	private static final String NEXT_PAGE = "forward:login.jsp";
	
	private RandomNumberGenerator rng;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		rng = new SecureRandomNumberGenerator();
		
		Object passwordSalt = rng.nextBytes();
		
		String hashedPassword = new Sha512Hash(password,passwordSalt.toString(),ITERATIONS).toBase64();
		
		User user = new User(username, hashedPassword);
		
		user.setPasswordSalt(passwordSalt.toString());
		
		UserRoles userRoles = new UserRoles(username, "sales");
		
		userService.addUser(user,userRoles);
		
		return NEXT_PAGE;
	}
	
}

