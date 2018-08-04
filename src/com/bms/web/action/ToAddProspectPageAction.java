package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;
import com.bms.domain.Employee;
import com.bms.service.CustomerService;
import com.bms.service.EmployeeService;

public class ToAddProspectPageAction extends AbstractAction {

	private CustomerService customerService;
	
	private EmployeeService employeeService;
	
	private static final String NEXT_PAGE = "forward:addProspect.jsp";
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		List<Customer> customerList = (List<Customer>) customerService.listCustomers();
		
		request.setAttribute("CUSTOMER_LIST", customerList);
		
		List<Employee> employeeList = (List<Employee>) employeeService.listEmployees();
		
		request.setAttribute("EMPLOYEE_LIST", employeeList);
		
		return NEXT_PAGE;
		
	}

	public CustomerService getCustomerService() {
		
		return customerService;
	
	}

	public void setCustomerService(CustomerService customerService) {
	
		this.customerService = customerService;
	
	}

	public EmployeeService getEmployeeService() {
	
		return employeeService;
	
	}

	public void setEmployeeService(EmployeeService employeeService) {
	
		this.employeeService = employeeService;
	
	}

}
