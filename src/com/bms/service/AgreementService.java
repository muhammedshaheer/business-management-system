package com.bms.service;

import java.util.List;

import com.bms.domain.Agreement;

public interface AgreementService {

	public Agreement addAgreement(Agreement agreement);
	
	public List<Agreement> listAgreements();
	
	public Agreement getAgreement(int agreementId);
	
	public List<Integer> getAvailableAgreements();
	
	public int getAgreementId(String prospectName);
	
	public Agreement updateAgreement(Agreement agreement);
	
	public int count();
	
	public int getMaxID();
	
	public int confirmedAgreementCount();
	
	public int notConfirmedAgreementCount();
	
}
