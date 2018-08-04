package com.bms.web.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;
import com.bms.domain.Prospect;

public class ViewAgreementAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:viewAgreement.jsp";
	
	public String execute(HttpServletRequest request,HttpServletResponse response) {
	
		int agreementId = Integer.parseInt(request.getParameter("agreementId"));

		Agreement agreement = agreementService.getAgreement(agreementId);
	
		if( null != agreement){   
			
			Prospect prospect= prospectService.getProspect(agreement.getProspectId());
	
			request.setAttribute("agreementObj", agreement);
		
			request.setAttribute("prospectName", prospect.getProspectName());
			
		}	else {
			
				throw new RuntimeException("No agreement with the given agreement id");
				
			}
	
	
    return NEXT_PAGE;
		
	}


}
