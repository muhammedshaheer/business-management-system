package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Prospect;

public class UpdateProspectStatusAction extends AbstractAction {
	
	private static String NEXT_PAGE = "forward:listProspect.do";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		int prospectID = Integer.parseInt(request.getParameter("prospectID"));
		 
		Prospect prospect = prospectService.getProspect(prospectID);
		
		if(null!=prospect){
			
			String status = request.getParameter("status");
			
			if(status.equals("Accept")){
				
				request.setAttribute("status", "Accept");
				
				NEXT_PAGE = "forward:acceptProspect.do";
				
			} else{
			
				prospect.setStatus(status);
			
				prospectService.updateProspect(prospect);
				
				request.setAttribute("prospect", prospect);
				
			}
			
		}
		
			return NEXT_PAGE;
	}
	
}

