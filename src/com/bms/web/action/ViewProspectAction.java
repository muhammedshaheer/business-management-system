package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;
import com.bms.domain.Employee;
import com.bms.domain.Prospect;

public class ViewProspectAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:viewProspect.jsp";

	private static final String PROSPECT = "prospect";
	
	private static final String CUSTOMER = "customer";
	
	private static final String EMPLOYEE = "employee";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String prospectID = request.getParameter("prospectID");
		
		Prospect prospect = prospectService.getProspect(Integer.parseInt(prospectID));
		
		int customerID = prospect.getCustomerID();
		
		Customer customer = customerService.getCustomer(customerID);
		
		int employeeID = prospect.getEmployeeInChargeID();
		
		Employee employee = employeeService.getEmployee(String.valueOf(employeeID));
		
		request.setAttribute(PROSPECT, prospect);
		
		request.setAttribute(CUSTOMER, customer);
		
		request.setAttribute(EMPLOYEE, employee);
		
		return NEXT_PAGE;
		
	}
	
}
