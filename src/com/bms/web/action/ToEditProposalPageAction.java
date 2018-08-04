package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Proposal;
import com.bms.domain.Prospect;

public class ToEditProposalPageAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:editProposal.jsp";
	
	private static final String DATA_ATTRIBUTE = "proposalID";

	private static final String REGEX = "[0-9]+";

	private static final String PROPOSAL = "proposal";

	private static final String PROSPECT = "prospect";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		String proposalID = (String) request.getParameter(DATA_ATTRIBUTE);
		
		if( null != proposalID && proposalID.matches(REGEX)) {
			
			Proposal proposal = proposalService.getProposal(Integer.parseInt(proposalID));
			Prospect prospect = prospectService.getProspect(proposal.getProspectID());
			request.setAttribute(PROPOSAL, proposal);
			request.setAttribute(PROSPECT, prospect);
		
			
		} else{
			
			
			throw new RuntimeException("Invalid ProposalID");
			
		}
		
		return NEXT_PAGE;
	}

}
