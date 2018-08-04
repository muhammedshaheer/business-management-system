package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Proposal;

public class ViewProposalAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:viewProposal.jsp";
	
	private static final String REGEX = "[0-9]+";

	private static final String DATA_ATTRIBUTE = "proposal";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String proposalID = request.getParameter("proposalID");

		Proposal proposal = null;
		
		if(proposalID.matches(REGEX)){
		
			proposal = proposalService.getProposal(Integer.parseInt(proposalID));
			
			request.setAttribute(DATA_ATTRIBUTE, proposal);
		
		}else{
			
			throw new RuntimeException("Invalid Proposal Id");
			
		}
		
		
		return NEXT_PAGE;
	}

}
