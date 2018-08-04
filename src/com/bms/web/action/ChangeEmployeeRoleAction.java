package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Employee;

public class ChangeEmployeeRoleAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listEmployee.do";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String employeeID = request.getParameter("employeeID");
		 
		Employee employee = employeeService.getEmployee(employeeID);
		
		if(null!=employee){
			
			String designation = request.getParameter("designation");
			
	        employee.setDesignation(designation);
			
			employeeService.updateEmployee(employee);
			
			request.setAttribute("employee", employee);
			
		}
		
			return NEXT_PAGE;
	}

}