package com.bms.service;

import java.util.List;

import com.bms.domain.Prospect;

public interface ProspectService {

	public Prospect addProspect(Prospect prospect);
	
	public List<Prospect> listViewProspects(int lowerLimit, int upperLimit);
	
	public List<Prospect> listProspects();
	
	public List<Prospect> unacceptedProspects();
	
	public List<Prospect> acceptedProspects();
	
	public List<Prospect> pendingProspects();
	
	public List<Prospect> rejectedProspects();
	
	public Prospect getProspect(int prospectID);
	
	public Prospect getProspect(String prospectName);
	
	public Prospect updateProspect(Prospect prospect);
	
	public Prospect updateProposalID(int prospectID,int proposalID);
	
	public int count();
	
	public int getMaxID();
	
	public int acceptedProspectsCount();
	
	public int rejectedProspectsCount();
	
	public int pendingProspectsCount();
	
}
