package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Employee;

public class ViewEmployeeAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:viewEmployee.jsp";

	private static final String EMPLOYEE = "employee";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String employeeID = request.getParameter("employeeID");
		
		Employee employee = null;
		
		employee = employeeService.getEmployee(employeeID);
			
		request.setAttribute(EMPLOYEE, employee);
		
		return NEXT_PAGE;
		
	}
	
}
