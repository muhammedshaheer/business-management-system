package com.bms.service;

import java.util.List;

import com.bms.domain.Proposal;

public interface ProposalService {
	
	public void addProposal(Proposal proposal);
	
	public List<Proposal> listProposal();
	
	public Proposal getProposal(int proposalID);
	
	public Proposal update(Proposal proposal);
	
	public int count();
	
	public int getMaxID();
	
	public int acceptedProposalsCount();

}
