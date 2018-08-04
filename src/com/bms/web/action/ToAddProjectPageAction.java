package com.bms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;
import com.bms.domain.Employee;
import com.bms.domain.Prospect;

public class ToAddProjectPageAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:addProject.jsp";
	
	private static final String SAME_PAGE = "forward:project.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		 ArrayList<String> prospectNames = new ArrayList<String>();
		 
		 try{
			 List<Integer> agreements = agreementService.getAvailableAgreements();
			 	 
			 if(0 != agreements.size()){
				 
				 
		  
				 for(int agreementId : agreements){
			  
					 prospectNames.add(getProspectName(agreementId));
						
				 }
				 
			 }
			 
			 else{
				 
				 request.setAttribute("noAgreement", true);
				 
				 return SAME_PAGE;
			 }
				 
			 
			 
		 } catch(NullPointerException e){
			
			 e.printStackTrace();
			
			 throw new RuntimeException("no agreements yet");
		 }
		 request.setAttribute("prospectNames", prospectNames);
		  
		 request.setAttribute("employees", getEmployees());
		 
     	 return NEXT_PAGE;
	}

	
	private String getProspectName(int agreementId){
		
		Agreement agreement = agreementService.getAgreement(agreementId);
		
		Prospect prospect = prospectService.getProspect(agreement.getProspectId());
		
		String prospectName = prospect.getProspectName();
		
		return prospectName;
		
	}
	
	private ArrayList<String> getEmployees(){
	
		List<Employee> employeeList = employeeService.listEmployees(); 
		
		ArrayList<String> employees = new ArrayList<String>();
		
		for(Employee e : employeeList){
			
			String name = e.getFirstName() + " " + e.getLastName();
			
			employees.add(name);
		}
		
		return employees;
		
	}

	
}
