package com.bms.web.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Employee;
import com.bms.domain.User;
import com.bms.domain.UserRoles;
import com.bms.util.PasswordHash;

public class AddEmployeeAction extends AbstractAction {

	private static final String REGEX = "[0-9]+";

	private static final String NEXT_PAGE = "forward:listEmployee.do";

	private static final String SAME_PAGE = "forward:addEmployee.jsp";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		Employee employee = createEmployeeFromRequest(request, response);
		
		createUserFromRequest(request);
		
		if(employee != null){
			
			employeeService.addEmployee(employee);
			
			return NEXT_PAGE;
			
		}
		
		return SAME_PAGE;
		
	}

	private User createUserFromRequest(HttpServletRequest request) {
		
		String username = request.getParameter("emailId");
		
		String password = request.getParameter("phoneNumber");
		
		String designation = request.getParameter("designation");
		
		username = username.split("@")[0];
		
		ArrayList<String> list = PasswordHash.getHashedpassword(password);
		
		String hashedPassword = list.get(0);
		
		String salt = list.get(1);
		
		User user = new User(username, hashedPassword);
		
		user.setPasswordSalt(salt);
		
		UserRoles userRole = null;
		
		if ("CEO".equals(designation)||"CFO".equals(designation)||"CTO".equals(designation)) {
			
			userRole = new UserRoles(username, "admin");
			
		} else{
			
			userRole = new UserRoles(username, "sales");
			
		}
		
		userService.addUser(user,userRole);
		
		return user;
		
	}

	private Employee createEmployeeFromRequest(HttpServletRequest request, HttpServletResponse response) {
		
		Employee e = new Employee();

		String id = request.getParameter("id");
		
		String firstName = request.getParameter("firstName");
		
		String lastName = request.getParameter("lastName");
		
		String designation = request.getParameter("designation");
		
		String emailId = request.getParameter("emailId");
		
		String phoneNumber = request.getParameter("phoneNumber");
		
		if(validate(id, firstName, lastName, emailId, phoneNumber, designation)){
			
			if(id.matches(REGEX)){
				
				e.setEmployeeID(id);
			
			}else{
				
				request.setAttribute("errorMessage", "Invalid ID format");
				
				return null;
				
			}
			
			e.setFirstName(firstName);
			
			e.setLastName(lastName);
			
			if(designation != ""){
				
				e.setDesignation(designation);
				
			}else{
				
				request.setAttribute("errorMessage", "Invalid ID format");
				
				return null;
				
			}
			
			e.setEmailId(emailId);
			
			if(phoneNumber.matches(REGEX)){
				
				e.setPhoneNumber(phoneNumber);
				
			}else{
				
				request.setAttribute("errorMessage", "Invalid Number format");
				
				return null;
				
			}
			
		}else{
			
			request.setAttribute("errorMessage", "Please enter all the fields");
			
			return null;
			
		}
		
		return e;
	}

	private boolean validate(String id, String firstName, String lastName, String emailId, String phoneNumber, String designation) {

		if(id!="" && firstName!="" && lastName!="" && emailId!="" && phoneNumber!="" && designation!=""){
			
			return true;
			
		}
		
		return false;
	}

}
