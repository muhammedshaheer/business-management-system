package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Customer;
import com.bms.domain.Employee;
import com.bms.domain.Prospect;

public class ListProspectAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listProspect.jsp";
	
	private static final String PROSPECT_LIST = "prospectList";
	
	private static final String CUSTOMER_LIST = "customerList";
	
	private static final String EMPLOYEE_LIST = "employeeList";
	
	private static int upperLimit = 2 , lowerLimit = 1;

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String cat = request.getParameter("prospectCat");
		
		List<Prospect> prospectList = null;
		
		if(null == cat){
			
			String nextSet = request.getParameter("nextSet");
			
			System.out.println(nextSet);
			
			if("next".equals(nextSet)){
				
				lowerLimit += 2;
				
				upperLimit += 2;
				
			} else if("previous".equals(nextSet)){
				
				if(lowerLimit > 1){
					
					lowerLimit -= 2;
				
					upperLimit -= 2;
				
				}
				
			} else{
				
				lowerLimit = 1;
				
				upperLimit = 2;
				
			}
			
			
			prospectList = (List<Prospect>) prospectService.listViewProspects(lowerLimit, upperLimit);
			
		} else {
		
			if(cat.equals("all")){
				
				String nextSet = request.getParameter("nextSet");
				
				if("next".equals(nextSet)){
					
					lowerLimit += 2;
					
					upperLimit += 2;
					
				} else if("previous".equals(nextSet)){
					
					lowerLimit -= 2;
					
					upperLimit -= 2;
					
				} else{
					
					lowerLimit = 1;
					
					upperLimit = 2;
					
				}
					prospectList = (List<Prospect>) prospectService.listViewProspects(lowerLimit, upperLimit);
			
			} else if(cat.equals("accepted")){
			
				prospectList = (List<Prospect>) prospectService.acceptedProspects();
			
			} else if(cat.equals("rejected")){
			
				prospectList = (List<Prospect>) prospectService.rejectedProspects();
			
			} else if(cat.equals("pending")){
			
				prospectList = (List<Prospect>) prospectService.pendingProspects();
			
			} else {
			
			}
		
		}
		
		if(!(prospectList.isEmpty())){
			
			request.setAttribute(PROSPECT_LIST, prospectList);
			
		} else {
			
		}
		
		List<Customer> customerList = (List<Customer>) customerService.listCustomers();
		
		if(!(customerList.isEmpty())){
		
			request.setAttribute(CUSTOMER_LIST, customerList);
			
		} else {
			
			
			
		}
		
		List<Employee> employeeList = (List<Employee>) employeeService.listEmployees();
		
		if(!(employeeList.isEmpty())){
		
			request.setAttribute(EMPLOYEE_LIST, employeeList);
		
		} else {
			
		}
		
		return NEXT_PAGE;
		
	}

}
