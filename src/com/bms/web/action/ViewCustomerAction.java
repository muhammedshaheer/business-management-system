package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;

public class ViewCustomerAction extends AbstractAction {

	private static String NEXT_PAGE = "forward:viewCustomer.jsp";

	private static final String CUSTOMER = "customer";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String customerID = request.getParameter("customerID");
		
		Customer customer = null;
		
		customer = customerService.getCustomer(Integer.parseInt(customerID));
			
		request.setAttribute(CUSTOMER, customer);
		
		if((customer.getContactPerson()==null)||(customer.getCustomerPhone()==null)){
			
			NEXT_PAGE = "forward:toEditCustomerPage.do";
			
		}
		
		return NEXT_PAGE;
		
	}
	
}
