package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Agreement;
import com.bms.domain.Prospect;

public class ListAgreementAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:listAgreement.jsp";

	private static final String AGREEMENT_LIST = "agreementlist";

	private static final String PROSPECT_LIST = "prospectlist";

	public String execute(HttpServletRequest request,HttpServletResponse response) {

		List<Agreement> agreementList = agreementService.listAgreements();

		List<Prospect> prospectList = prospectService.listProspects();

		if (!(agreementList.isEmpty())) {
			request.setAttribute(AGREEMENT_LIST, agreementList);

			request.setAttribute(PROSPECT_LIST, prospectList);
		}

		else {
		}

		return NEXT_PAGE;
	}

}
