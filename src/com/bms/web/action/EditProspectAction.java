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

import com.bms.domain.Prospect;
import com.bms.util.FileUpload;

public class EditProspectAction extends AbstractAction {

private static final String NEXT_PAGE = "redirect:listProspect.do";
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private static final String REGEX = "[0-9]+";

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
					    	
					    		case "prospectID":
					    			
					    			prospect.setProspectID(Integer.parseInt(value));
					    			
					    			break;
					    	
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
					    			
					    			prospect.setProspectType(value);
					    			
					    			break;
					    			
					    		case "sector":
					    			
					    			prospect.setSector(value);
					    			
					    			break;
					    			
					    		case "customer":
					    				
					    			prospect.setCustomerID(Integer.parseInt(value));
					    			
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
					    			
					    			if(value.matches(REGEX)){
					    			
					    				prospect.setBudget(Integer.parseInt(value));
					    				
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
						
						int ID = prospect.getProspectID();
						
						String linkToFile = FileUpload.doUpload(item, "prospect", ID);
						
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
		
		prospectService.updateProspect(prospect);
		
		return NEXT_PAGE;
	
	}

}
