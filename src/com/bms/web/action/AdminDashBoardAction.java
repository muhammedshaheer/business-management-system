package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDashBoardAction extends AbstractAction{
	
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
	
	private static final String EMPLOYEE_DATA_ATTRIBUTE = "employeeTotalCount";
	
	private static final String EMPLOYEE_SENIOR_DATA_ATTRIBUTE = "seniorOfficersCount";
	
	private static final String EMPLOYEE_SALES_DATA_ATTRIBUTE = "salesCount";
	
	private static final String EMPLOYEE_MANAGERS_DATA_ATTRIBUTE = "managersCount";
	
	private static final String PROJECT_DATA_ATTRIBUTE = "projectTotalCount";
	
	private static final String PROJECT_NOT_YET_STARTED_DATA_ATTRIBUTE = "projectNotStartedCount";
	
	private static final String PROJECT_IN_PROGRESS_DATA_ATTRIBUTE = "projectInProgressCount";
	
	private static final String PROJECT_TESTING_DATA_ATTRIBUTE = "projectTestingCount";
	
	private static final String PROJECT_DEPLOYED_DATA_ATTRIBUTE = "projectDeployedCount";
	
	private static final String PAYMENT_DATA_ATTRIBUTE = "paymentTotalCount";
	
	private static final String PAYMENT_PAYED_DATA_ATTRIBUTE = "paidCount";
	
	private static final String PAYMENT_NOT_PAYED_DATA_ATTRIBUTE = "notPaidCount";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute(PROSPECT_DATA_ATTRIBUTE, prospectService.count());
		
		request.setAttribute(PROSPECT_ACCEPT_DATA_ATTRIBUTE, prospectService.acceptedProspectsCount());
		
		request.setAttribute(PROSPECT_REJECT_DATA_ATTRIBUTE, prospectService.rejectedProspectsCount());
		
		request.setAttribute(PROSPECT_PENDING_DATA_ATTRIBUTE, prospectService.pendingProspectsCount());
		
		request.setAttribute(PROPOSAL_DATA_ATTRIBUTE, proposalService.count());
		
		request.setAttribute(PROPOSAL_ACCEPT_DATA_ATTRIBUTE, proposalService.acceptedProposalsCount());
		
		request.setAttribute(AGREEMENT_DATA_ATTRIBUTE, agreementService.count());
		
		request.setAttribute(AGREEMENT_CONFIRM_DATA_ATTRIBUTE, agreementService.confirmedAgreementCount());
		
		request.setAttribute(AGREEMENT_NOT_CONFIRM_DATA_ATTRIBUTE, agreementService.notConfirmedAgreementCount());
		
		request.setAttribute(ADMIN_USER_DATA_ATTRIBUTE, employeeService.adminUserCount());
		
		request.setAttribute(SALES_USER_DATA_ATTRIBUTE, employeeService.salesUserCount());

		request.setAttribute(EMPLOYEE_DATA_ATTRIBUTE, employeeService.count());

		request.setAttribute(EMPLOYEE_SENIOR_DATA_ATTRIBUTE, employeeService.seniorOfficersCount());

		request.setAttribute(EMPLOYEE_SALES_DATA_ATTRIBUTE, employeeService.salesCount());

		request.setAttribute(EMPLOYEE_MANAGERS_DATA_ATTRIBUTE, employeeService.managersCount());
		
		request.setAttribute(PROJECT_DATA_ATTRIBUTE, projectService.count());
		
		request.setAttribute(PROJECT_NOT_YET_STARTED_DATA_ATTRIBUTE, projectService.notYetStartedCount());
		
		request.setAttribute(PROJECT_IN_PROGRESS_DATA_ATTRIBUTE, projectService.inProgressCount());
		
		request.setAttribute(PROJECT_TESTING_DATA_ATTRIBUTE, projectService.testingCount());
		
		request.setAttribute(PROJECT_DEPLOYED_DATA_ATTRIBUTE, projectService.deployedCount());
		
		request.setAttribute(PAYMENT_DATA_ATTRIBUTE, paymentMilestoneService.count());
		
		request.setAttribute(PAYMENT_PAYED_DATA_ATTRIBUTE, paymentMilestoneService.payedCount());
		
		request.setAttribute(PAYMENT_NOT_PAYED_DATA_ATTRIBUTE, paymentMilestoneService.notPayedCount());
		
		return NEXT_PAGE;
	}

}
