package com.bms.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bms.domain.Proposal;
import com.bms.util.FileUpload;

public class AddProposalAction extends AbstractAction {

	private static final String NEXT_PAGE = "redirect:listProposal.do";
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	@Override
	synchronized public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String value = null;
		
		Proposal proposal = new Proposal();
	
		if (ServletFileUpload.isMultipartContent(request)) {

			try {

				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				for (FileItem item : multiparts) {
					
					value = null;

					if (item.isFormField()) {
						
						String name = item.getFieldName();
						
					    value = item.getString();
					   
					    if ( null != value){
					    
					    	switch (name) {
					    	
					    	case "prospectID":
					    		
					    		System.out.println("prospectID "+ value);
					    		
					    		proposal.setProspectID(Integer.parseInt(value));
							
					    		break;
					    	case "proposalName":
								
					    		proposal.setProposalName(value);
					    		
								break;
					    	case "description":
					    		
					    		proposal.setDescription(value);
								
								break;
					    	case "dateOfAcceptance":
					    		
					    		Date dateOfAcceptance = null;
								
								try {

									dateOfAcceptance = new SimpleDateFormat(DATE_FORMAT).parse(value);
									
								} catch (ParseException e) {

									e.printStackTrace();

								}
					    		
					    		proposal.setDateOfAcceptance(dateOfAcceptance);
								
								break;

					    	default:
					    		break;
					    	}
					    	
					    }
					    
					} else{
						
						int maxID = proposalService.getMaxID();
						
						String linkToFile = FileUpload.doUpload(item, "proposal",maxID);
						
						proposal.setLinkToFile(linkToFile);
						
					}
					
					
				}
			}catch(Exception e){
				
				e.printStackTrace();
				
				throw new RuntimeException(e.getMessage());
				
			}
		}
		
		Date dateOfModification = new Date();
		
		proposal.setDateOfModification(dateOfModification);
	
		proposalService.addProposal(proposal);
		
		prospectService.updateProposalID(proposal.getProspectID(), proposal.getProposalID());
		
		return NEXT_PAGE;
	}
	
}
				
						
					

						

					
		
		
		
	
	
	
