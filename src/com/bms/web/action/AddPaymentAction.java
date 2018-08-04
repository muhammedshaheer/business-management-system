package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;
import com.bms.domain.Payment;

public class AddPaymentAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listProject.do";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("in add payment.do");
	
		Payment payment = new Payment();
		
		Double dueAmount= 0.0;
		
		Integer agreementId=(Integer)request.getAttribute("agreementId");
		
		Integer projectId= (Integer) request.getAttribute("projectId");
		
		Agreement agreement = agreementService.getAgreement(agreementId);
		
		payment.setAgreementId(agreementId);
		
	    payment.setDueAmount(dueAmount);
	    
	    payment.setTotalAmount(agreement.getEstimateAmount());
	    
	    payment.setProjectId(projectId);
	    
	    paymentService.addPayment(payment);
		
		return NEXT_PAGE;
	}

}
