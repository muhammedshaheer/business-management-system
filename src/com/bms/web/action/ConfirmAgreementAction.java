package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;

public class ConfirmAgreementAction extends AbstractAction {

	private static final String NEXT_PAGE = "redirect:listAgreement.do";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		int agreementId = Integer.parseInt(request.getParameter("agreementId"));
		
		 
		Agreement agreement = agreementService.getAgreement(agreementId);
		
		request.setAttribute("agreementId", agreementId);
		
		
		
         if(null!=agreement){
			
	        agreement.setConfirm(true);
			
			agreementService.updateAgreement(agreement);
			

		}
		
			return NEXT_PAGE;
	}

}
