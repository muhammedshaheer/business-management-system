package com.bms.web.action;

import com.bms.service.AgreementService;
import com.bms.service.CustomerService;
import com.bms.service.EmployeeService;
import com.bms.service.InvoiceService;
import com.bms.service.PaymentMilestoneService;
import com.bms.service.PaymentService;
import com.bms.service.ProjectService;
import com.bms.service.ProposalService;
import com.bms.service.ProspectService;
import com.bms.service.RequirementService;
import com.bms.service.UserService;


public abstract class AbstractAction implements Action {
	
	protected UserService userService;
	
	protected ProspectService prospectService;

	protected ProposalService proposalService;
	
	protected EmployeeService employeeService;
	
	protected CustomerService customerService;
	
	protected AgreementService agreementService;
	
	protected PaymentMilestoneService paymentMilestoneService;
	
	protected PaymentService paymentService;
	
	protected ProjectService projectService;
	
	protected RequirementService requirementService;
	
	protected InvoiceService invoiceService;
	
	

	public RequirementService getRequirementService() {
		return requirementService;
	}


	public void setRequirementService(RequirementService requirementService) {
		this.requirementService = requirementService;
	}


	public CustomerService getCustomerService() {
		
		return customerService;
	
	}
	

	public void setCustomerService(CustomerService customerService) {
	
		this.customerService = customerService;
	
	}
	

	public AgreementService getAgreementService() {
		return agreementService;
	}


	public void setAgreementService(AgreementService agreementService) {
		this.agreementService = agreementService;
	}


	public EmployeeService getEmployeeService() {
		
		return employeeService;
	
	}

	public void setEmployeeService(EmployeeService employeeService) {
	
		this.employeeService = employeeService;
	
	}

	public ProposalService getProposalService() {
		
		return proposalService;
		
	}

	public void setProposalService(ProposalService proposalService) {
		
		this.proposalService = proposalService;
		
	}

	public UserService getUserService() {
		
		return userService;
		
	}

	public void setUserService(UserService userService) {
		
		this.userService = userService;
		
	}
	
	public ProspectService getProspectService() {
		
		return prospectService;
	
	}

	public void setProspectService(ProspectService prospectService) {
	
		this.prospectService = prospectService;
	
	}
	
	public PaymentMilestoneService getPaymentMilestoneService() {
		
		return paymentMilestoneService;
	}


	public void setPaymentMilestoneService(PaymentMilestoneService paymentMilestoneService) {
		
		this.paymentMilestoneService = paymentMilestoneService;
	}


	public PaymentService getPaymentService() {
		return paymentService;
	}


	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}


	public ProjectService getProjectService() {
		return projectService;
	}


	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}


	public InvoiceService getInvoiceService() {
		return invoiceService;
	}


	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	

}
