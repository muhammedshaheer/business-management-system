package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Prospect;

public class ToAddAgreementPageAction extends AbstractAction {
	
	private static final String NEXT_PAGE = "forward:addAgreement.jsp";
	
	private static final String SAME_PAGE = "forward:listAgreement.do";

	private static final String ERROR_MSG = "ERROR_MSG";

	private static final Object MESSAGE = "No Accepted Prospects";

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		
		
		List<Prospect> prospectList = prospectService.acceptedProspects();
		
	
		if(!prospectList.isEmpty()){
		
		
			request.setAttribute("prospectList", prospectList);
		
		} else{
			
			request.setAttribute(ERROR_MSG, MESSAGE);
			
			return SAME_PAGE;
		}
		return NEXT_PAGE;
	}

}
