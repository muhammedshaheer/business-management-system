package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaleDashBoardAction extends AbstractAction {

private static final String NEXT_PAGE = "forward:index.jsp";
	
	private static final String PROSPECT_DATA_ATTRIBUTE = "prospectTotalCount";
	
	private static final String PROSPECT_ACCEPT_DATA_ATTRIBUTE = "prospectAcceptCount";
	
	private static final String PROSPECT_REJECT_DATA_ATTRIBUTE = "prospectRejectCount";
	
	private static final String PROSPECT_PENDING_DATA_ATTRIBUTE = "prospectPendingCount";
	
	private static final String PROPOSAL_DATA_ATTRIBUTE = "proposalTotalCount";
	
	private static final String PROPOSAL_ACCEPT_DATA_ATTRIBUTE = "proposalAcceptCount";
	
	private static final String AGREEMENT_DATA_ATTRIBUTE = "agreementTotalCount";
	
	private static final String AGREEMENT_NOT_CONFIRM_DATA_ATTRIBUTE = "agreementNotConfirmCount";
	
	private static final String AGREEMENT_CONFIRM_DATA_ATTRIBUTE = "agreementConfirmCount";
	
	private static final String ADMIN_USER_DATA_ATTRIBUTE = "adminUserCount";
	
	private static final String SALES_USER_DATA_ATTRIBUTE = "salesUserCount";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("in sales dashboard action");
		
		request.setAttribute(PROSPECT_DATA_ATTRIBUTE, prospectService.count());
		System.out.println("in sales dashboard action1");
		request.setAttribute(PROSPECT_ACCEPT_DATA_ATTRIBUTE, prospectService.acceptedProspectsCount());
		System.out.println("in sales dashboard action2");
		request.setAttribute(PROSPECT_REJECT_DATA_ATTRIBUTE, prospectService.rejectedProspectsCount());
		System.out.println("in sales dashboard action3");
		request.setAttribute(PROSPECT_PENDING_DATA_ATTRIBUTE, prospectService.pendingProspectsCount());
		System.out.println("in sales dashboard action4");
		request.setAttribute(PROPOSAL_DATA_ATTRIBUTE, proposalService.count());
		System.out.println("in sales dashboard action5");
		request.setAttribute(PROPOSAL_ACCEPT_DATA_ATTRIBUTE, proposalService.acceptedProposalsCount());
		System.out.println("in sales dashboard action6");
		request.setAttribute(AGREEMENT_DATA_ATTRIBUTE, agreementService.count());
		System.out.println("in sales dashboard action7");
		request.setAttribute(AGREEMENT_CONFIRM_DATA_ATTRIBUTE, agreementService.confirmedAgreementCount());
		System.out.println("in sales dashboard action8");
		request.setAttribute(AGREEMENT_NOT_CONFIRM_DATA_ATTRIBUTE, agreementService.notConfirmedAgreementCount());
		System.out.println("in sales dashboard action9");
		request.setAttribute(ADMIN_USER_DATA_ATTRIBUTE, employeeService.adminUserCount());
		System.out.println("in sales dashboard action10");
		request.setAttribute(SALES_USER_DATA_ATTRIBUTE, employeeService.salesUserCount());

		System.out.println("in sales dashboard action  : next page : " + NEXT_PAGE);
		
		return NEXT_PAGE;
	}

}
