package com.bms.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;

import com.bms.domain.Agreement;
import com.bms.domain.Employee;
import com.bms.domain.Project;
import com.bms.domain.Prospect;

public class AddProjectAction extends AbstractAction {
	
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String NEXT_PAGE = "forward:addPayment.do";

	//private static final String SAME_PAGE = "forward:addProject.jsp";
	
	private static final String ERROR_MESSAGE = "errorMessage";

	//private static final String SUCCESS_MESSAGE = "successMessage";
	

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		Project project = createProject(request, response);
	
		if(null != project){
			

			System.out.println("in add project do : project not null");
			
			projectService.addProject(project);
			
			//request.setAttribute(SUCCESS_MESSAGE, "Project successfully added");
			
			request.setAttribute("agreementId", project.getAgreementID());
			
			request.setAttribute("projectId", project.getProjectID());

		} else{
			
		}
		
		return NEXT_PAGE;
	}
	

	private Project createProject(HttpServletRequest request, HttpServletResponse response) {
		
		
		Project project = new Project();
		
		String projectName = request.getParameter("projectName");
		
		Date commencementDate = null;
				
		try {

			commencementDate = new SimpleDateFormat(DATE_FORMAT).parse(request.getParameter("commencementDate"));
			
			project.setCommencementDate(commencementDate);
			
    	} catch (ParseException e) {
    	
    		e.printStackTrace();

    	}
		
		Date completionDate = null;
		
		try {

			completionDate = new SimpleDateFormat(DATE_FORMAT).parse(request.getParameter("completionDate"));
			
			project.setCompletionDate(completionDate);
			
    	} catch (ParseException e) {
    		
    		System.out.println("caught 2");

    		e.printStackTrace();

    	}

		String status = request.getParameter("status");
		
		String prospectName = request.getParameter("prospectName");

		String projectHead = request.getParameter("projectHead");
		
		int agreementId = getAgreementID(prospectName);

		if(!(checkNull(projectName, commencementDate, prospectName, projectHead))){
			
			request.setAttribute(ERROR_MESSAGE, "Fill all required fields");
					
			return null;
		}	
	
		project.setAgreementID(agreementId);

		if(validateDate(commencementDate, completionDate, request)){
			
			
		} else{
			
			request.setAttribute(ERROR_MESSAGE, "Completion date cannot be before commencement date");
		
			return null;
		}
		
		project.setProjectName(projectName);
		
		project.setStatus(status);
		
		project.setProjectHead(findProjectHead(projectHead));

		return project;
		
	}
	

	private int getAgreementID(String prospectName) {
	
		/*Prospect prospect = prospectService.getProspect(prospectName);
		
		List<Agreement> agreementList = agreementService.listAgreements();
		
		int agreementId = 0;
		
		for(Agreement a : agreementList){
			
			if(a.getProspectId() == prospect.getProspectID()){
				
				agreementId = a.getAgreementId();
			}
		}
		*/
		int agreementId = agreementService.getAgreementId(prospectName);
		
		return agreementId;
	}


	private boolean validateDate(Date commencementDate, Date completionDate, HttpServletRequest request) {
		
		 if (completionDate.compareTo(commencementDate) >= 0) {
	            
			 return true;
			 
	     }
		 
		 else{
			 
			 return false;
		 } 
			 
	}
	

	private boolean checkNull(String projectName, Date commencementDate, String agreementID, String projectHead) {
		
		if(projectName=="" || projectHead==null || agreementID==""){
			System.out.println("in add project action : checknull : not all filled");
			return false;
		}
		System.out.println("in add project action : checknull : all filled");
		return true;
	}
	
	private int findProjectHead(String projectHead){
		
		int employeeId = 0;
		
		List<Employee> employeeList = employeeService.listEmployees();
		
		for(Employee e : employeeList){
			
			String employeeName = e.getFirstName() + " " + e.getLastName();
			
			if(employeeName.equals(projectHead)){
				
				employeeId = Integer.parseInt(e.getEmployeeID());
			}
		}
		
		return employeeId;
	}

}
