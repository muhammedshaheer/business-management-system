package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Proposal;

public class ListProposalAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listProposal.jsp";
	
	private static final String DATA_ATTRIBUTE = "proposalList";

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		List<Proposal> proposalList = (List<Proposal>) proposalService.listProposal();
		
		if( !proposalList.isEmpty() ){
		
			request.setAttribute(DATA_ATTRIBUTE, proposalList);
			
		} else{
			
			
			
		}
	
		return NEXT_PAGE;
		
	}
	
}