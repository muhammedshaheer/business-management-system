package com.bms.service;

import com.bms.domain.Requirement;

public interface RequirementService {
	
	public Requirement addRequirement(Requirement requirement);
	
	public Requirement getCurrentStat();
	
	public Requirement getProspectRequirement(int prospectID);

}
