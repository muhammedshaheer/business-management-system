package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Prospect;

public class UpdateProspectCategoryAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listProspect.do";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		int prospectID = Integer.parseInt(request.getParameter("prospectID"));
		 
		Prospect prospect = prospectService.getProspect(prospectID);
		
		if(null!=prospect){
			
			String category = request.getParameter("category");
			
	        prospect.setCategory(category);
			
			prospectService.updateProspect(prospect);
			
			request.setAttribute("prospect", prospect);
			
		}
		
			return NEXT_PAGE;
	}

}