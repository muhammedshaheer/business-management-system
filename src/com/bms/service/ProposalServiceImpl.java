package com.bms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Proposal;

public class ProposalServiceImpl implements ProposalService {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {

		return template;

	}

	public void setTemplate(HibernateTemplate template) {

		this.template = template;

	}

	@Override
	public void addProposal(Proposal proposal) {
		
		template.save(proposal);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposal> listProposal() {
		
		List<Proposal> proposalList = new ArrayList<Proposal>();

		proposalList = template.loadAll(Proposal.class);

		return Collections.unmodifiableList(proposalList);
	
	}

	@Override
	public Proposal getProposal(int proposalID) {
		
		Proposal proposal = null;
		
		proposal = (Proposal)template.get(Proposal.class, proposalID);
			
		return proposal;
	}

	@Override
	public int count() {
	
		return DataAccessUtils.intResult(template.find("select count(*) from Proposal"));
	
	}
	
	public int getMaxID() {
		
		int maxID = 0;
		
		try {
		
		maxID = DataAccessUtils.intResult(template.find("select max(proposalID) from Proposal"));
		
		} catch (NullPointerException e){
			
			return 0;
			
		}
		
		return maxID;
		
	}
	@Override
	public Proposal update(Proposal proposal) {
		
		template.update(proposal);
		
		return proposal;
	}

	@Override
	public int acceptedProposalsCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Proposal WHERE status = 'Accept'"));
	
	}

}
