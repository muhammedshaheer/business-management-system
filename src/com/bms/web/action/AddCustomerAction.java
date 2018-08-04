package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;
import com.bms.service.CustomerService;

public class AddCustomerAction extends AbstractAction {

	private CustomerService customerService;
	
	private static final String NEXT_PAGE = "forward:addCustomer.jsp";

	private static final String SAME_PAGE = "forward:addCustomer.jsp";

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		Customer customer = createCustomerFromRequest(request, response);
		
		if(customer != null){
			
			customerService.addCustomer(customer); 
			
			return NEXT_PAGE;
			
		} else {
		
		return SAME_PAGE;
		
		}
		
	}

	private Customer createCustomerFromRequest(HttpServletRequest request, HttpServletResponse response) {
		
		Customer customer = new Customer();
		
		String customerName = request.getParameter("customerName");
		
		String contactPerson = request.getParameter("contactPerson");
		
		String customerEmailID = request.getParameter("customerEmailID");
		
		String customerPhone = request.getParameter("customerPhone");
			
		if(hasNullFields(customerName,contactPerson,customerEmailID,customerPhone)){
			
			request.setAttribute("errorMessage", "Fields cannot be empty!");
			
		}
		
		customer.setCustomerName(customerName);
		
		customer.setContactPerson(contactPerson);
		
		customer.setCustomerEmailID(customerEmailID);
		
		customer.setCustomerPhone(customerPhone);
		
		return customer;
		
	}

	private boolean hasNullFields(String customerName, String contactPerson, String customerEmailID, String customerPhone) {

		if(customerName=="" || contactPerson=="" || customerEmailID=="" || customerPhone==""){
			
			return true;
			
		}
		
		return false;
	}

	public CustomerService getCustomerService() {
		
		return customerService;
	
	}

	public void setCustomerService(CustomerService customerService) {
	
		this.customerService = customerService;
	
	}

}
