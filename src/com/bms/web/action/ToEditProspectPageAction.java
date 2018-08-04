package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;
import com.bms.domain.Employee;
import com.bms.domain.Prospect;

public class ToEditProspectPageAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:editProspect.jsp";

	private static final String PROSPECT = "prospect";
	
	private static final String CUSTOMER = "customer";
	
	private static final String EMPLOYEE = "employee";
	
	private static final String CUSTOMER_LIST = "customerList";
	
	private static final String EMPLOYEE_LIST = "employeeList";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String prospectID = request.getParameter("prospectID");
		
		Prospect prospect = prospectService.getProspect(Integer.parseInt(prospectID));
		
		int customerID = prospect.getCustomerID();
		
		Customer customer = customerService.getCustomer(customerID);
		
		int employeeID = prospect.getEmployeeInChargeID();
		
		Employee employee = employeeService.getEmployee(String.valueOf(employeeID));
		
		List<Customer> customerList = (List<Customer>) customerService.listCustomers();
		
		List<Employee> employeeList = (List<Employee>) employeeService.listEmployees();
		
		request.setAttribute(CUSTOMER_LIST, customerList);
		
		request.setAttribute(EMPLOYEE_LIST, employeeList);
		
		request.setAttribute(PROSPECT, prospect);
		
		request.setAttribute(CUSTOMER, customer);
		
		request.setAttribute(EMPLOYEE, employee);
		
		return NEXT_PAGE;
		
	}
	
}
