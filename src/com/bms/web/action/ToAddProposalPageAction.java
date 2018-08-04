package com.bms.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Prospect;

public class ToAddProposalPageAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:addProposal.jsp";
	
	private static final String DATA_ATTRIBUTE = "prospect";

	private static final String DATA_ATTRIBUTE_TO_PAGE = "prospectList";

	private static final String SAME_PAGE = "forward:listProposal.do";

	private static final String ERROR_MSG = "ERROR_MSG";

	private static final Object MESSAGE = "Please Add a Prospect";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		Prospect prospect = (Prospect) request.getAttribute(DATA_ATTRIBUTE);
		
		List<Prospect> prospectList = null;
	
		if(null == prospect){
			
			prospectList = prospectService.unacceptedProspects();
			
			if(prospectList.isEmpty()){
				
				request.setAttribute(ERROR_MSG, MESSAGE);
			
				return SAME_PAGE;
			
			}
		
		} else{
			
			prospectList = new ArrayList<Prospect>();
			
			prospectList.add(prospect);
		}
		
		request.setAttribute(DATA_ATTRIBUTE_TO_PAGE, prospectList);
		
		request.setAttribute(DATA_ATTRIBUTE, null);
		
		return NEXT_PAGE;
	}

}
