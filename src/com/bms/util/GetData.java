package com.bms.util;

import com.bms.service.AgreementService;
import com.bms.service.AgreementServiceImpl;
import com.bms.service.ProspectService;
import com.bms.service.ProspectServiceImpl;

public class GetData {
	
	public static String getProspectName(int agreementId){
		
		AgreementService agreementService = new AgreementServiceImpl();
		
		ProspectService prospectService = new ProspectServiceImpl();
		
		return (prospectService.getProspect(agreementService.getAgreement(agreementId).getProspectId())).getProspectName();
		
	}

}
