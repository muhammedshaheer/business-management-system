package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Proposal;

public class UpdateProposalStatusAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listProposal.do";
	
	private static final String DATA_ATTRIBUTE = "proposalID";

	private static final String REGEX = "[0-9]+";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String proposalID = (String) request.getParameter(DATA_ATTRIBUTE);
		
		System.out.println(proposalID);
		
		if( null != proposalID && proposalID.matches(REGEX)){
		
			Proposal proposal = proposalService.getProposal(Integer.parseInt(proposalID));
			
			proposal.setStatus("Accept");
			
			proposalService.update(proposal);
			
		} else{
			
			throw new RuntimeException("Invalid Proposal ID");
			
		}
		
		return NEXT_PAGE;
	}

}
