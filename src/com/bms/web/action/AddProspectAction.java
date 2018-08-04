package com.bms.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bms.domain.Customer;
import com.bms.domain.Prospect;
import com.bms.domain.Requirement;
import com.bms.util.FileUpload;

public class AddProspectAction extends AbstractAction {
	
	
	private static final String NEXT_PAGE = "redirect:listProspect.do";
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String REGEX = "-?\\d+(\\.\\d+)?";

	

	@Override
	synchronized public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		int flag = 0;
		
		String value;
		
		Prospect prospect = new Prospect();
		
		if (ServletFileUpload.isMultipartContent(request)) {
		
			try {
				
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				ListIterator<FileItem> iterator = multiparts.listIterator();
				
				while(iterator.hasNext()) {
					
					FileItem item = iterator.next();
					

					if (item.isFormField()) {
						
						String name = item.getFieldName();
						
					    value = item.getString();
					    
					    if ( null != value && !"".equals(value)){
					    	
					    	
					    	switch (name) {
					    	
					    		case "prospectName":
					    			
					    			prospect.setProspectName(value);
					    		
					    			break;
					    			
					    		case "dateOfIdentification":
					    		
					    			Date dateOfIdentification = null;
								
					    			try {

					    				dateOfIdentification = new SimpleDateFormat(DATE_FORMAT).parse(value);
									
					    			} catch (ParseException e) {

					    				e.printStackTrace();

					    			}
					    		
					    			prospect.setDateOfIdentification(dateOfIdentification);
								
					    			break;
					    			
					    		case "specification":
					    			
					    			prospect.setSpecification(value);
					    		
					    			break;
					    			
					    		case "typeOfProspect":
					    			
					    				if(value.equals("RFT")){
					    					
					    				prospect.setProspectType(value);
					    				
					    				Requirement requirement = new Requirement();
					    				
					    				item = iterator.next();
					    				
					    				value = item.getString();
					    				
					    				requirement.setExperience(Integer.parseInt(value));
					    			
					    				item = iterator.next();
					    				
					    				value = item.getString();
					    				
					    				requirement.setProfessionalStaff(Integer.parseInt(value));
					    				
					    				item = iterator.next();
					    				
					    				value = item.getString();
					    				
					    				requirement.setAverageAnnualTurnover(Integer.parseInt(value));
					    				
					    				int prosID = prospectService.getMaxID() + 1;
					    				
					    				requirement.setProspectID(prosID);
					    				
					    				requirement = requirementService.addRequirement(requirement);
					    				
					    				requirement.setRequirementID(requirement.getRequirementID());
					    				
					    				
					    			} else {
					    				
					    				prospect.setProspectType(value);
					    				
					    				item = iterator.next();
					    				
					    				item = iterator.next();
					    				
					    				item = iterator.next();
					    				
					    			}
					    			
					    			break;
					    			
					    		case "sector":
					    			
					    			prospect.setSector(value);
					    			
					    			break;
					    			
					    		case "customer":
					    			
					    			if(value.equals("addNewCustomer")){
					    				
					    				Customer customer = new Customer();
					    				
					    				item = iterator.next();
					    				
					    				value = item.getString();
					    				
					    				customer.setCustomerName(value);
					    			
					    				item = iterator.next();
					    				
					    				value = item.getString();
					    				
					    				customer.setCustomerEmailID(value);
					    				
					    				customer = customerService.addCustomer(customer);
					    				
					    				prospect.setCustomerID(customer.getCustomerID());
					    				
					    			} else {
					    				
					    				prospect.setCustomerID(Integer.parseInt(value));
					    				
					    				item = iterator.next();
					    				
					    				item = iterator.next(); //Skip customerCompany and email Id
					    				
					    				
					    			}
					    			
					    			break;
					    			
					    		case "source":
					    			
					    			prospect.setSource(value);
					    			
					    			break;
					    			
					    		case "responseDeadline":
					    			
					    			Date responseDeadline = null;
									
					    			try {

					    				responseDeadline = new SimpleDateFormat(DATE_FORMAT).parse(value);
									
					    			} catch (ParseException e) {

					    				e.printStackTrace();

					    			}
					    		
					    			prospect.setResponseDeadline(responseDeadline);
								
					    			break;
					    			
					    		case "employeeInCharge":
					    			
					    			prospect.setEmployeeInChargeID(Integer.parseInt(value));
					    			
					    			break;
					    			
					    		case "budget":
					    			System.out.println(value);
					    			System.out.println(value.matches(REGEX));
					    			if(value.matches(REGEX)){
					    				
					    				double budget = Double.parseDouble(value);
					    				
					    				budget *=1000;
					    				
					    				System.out.println((int)budget);
					    			
					    				prospect.setBudget((int)budget);
					    				
					    				System.out.println(prospect.getBudget());
					    				
					    			} else {
					    				
					    				flag ++;
					    				
					    			}
					    			
					    			break;
					    			
					    		case "status":
					    			
					    			prospect.setStatus(value);
					    			
					    			break;
					    			
					    		case "category":
					    			
					    			prospect.setCategory(value);
					    			
					    			break;

					    		default:
					    		
					    			break;
					    	}
					    	
					    } else{
					    	
					    	
					    		flag ++;
					    	
					    }
					    
					} else{
						
						int maxID = prospectService.getMaxID();
						
						String linkToFile = FileUpload.doUpload(item, "prospect", maxID);
						
						prospect.setLinkToFile(linkToFile);
						
					}
					
					
				}
				
			} catch(Exception e){
				
				throw new RuntimeException("Error occured while getting multipart form");
			}
		
		}
		
		if(flag>0){
			
			throw new RuntimeException("Invalid Data");
		}
		
		prospectService.addProspect(prospect);
		
		return NEXT_PAGE;
	
	}

}
