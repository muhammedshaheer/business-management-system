package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Employee;

public class ListEmployeeAction extends AbstractAction {
	
	private static final String DATA_ATTRIBUTE = "database";
	
	private static final String NEXT_PAGE = "forward:listEmployees.jsp";

	private static final String MSG_ATTRIBUTE = "errorMessage";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String desig = request.getParameter("employeeDesig");

		List<Employee> employeeList = null;
		
		if (null == desig){
		
			employeeList = employeeService.listEmployees();
		
		} else {
		
			if(desig.equals("all")){
			
				employeeList = (List<Employee>) employeeService.listEmployees();
			
			} else if(desig.equals("seniors")){
			
				employeeList = (List<Employee>) employeeService.listSeniorEmployees();
			
			} else if(desig.equals("sales")){
			
				employeeList = (List<Employee>) employeeService.listSalesEmployees();
			
			} else if(desig.equals("managers")){
			
				employeeList = (List<Employee>) employeeService.listManagerEmployees();
			
			} else {
			
			}
		
		}
		
		if(0 != employeeList.size()){
			
			request.setAttribute(DATA_ATTRIBUTE, employeeList);
			
		}else{
			
			request.setAttribute(MSG_ATTRIBUTE, "No employees found");
			
		}
		
		return NEXT_PAGE;
	}

}
