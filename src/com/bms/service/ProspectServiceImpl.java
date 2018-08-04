package com.bms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Prospect;

public class ProspectServiceImpl implements ProspectService {

	private static final String ACCEPTED_NO_PROPOSAL_LIST_QUERY = "FROM Prospect WHERE status = 'Accept' and proposalID is NULL";

	private static final String NONREJECTED_LIST_QUERY = "FROM Prospect WHERE status != 'Reject'";
	
	private static final String NONREJECTED_LIST_QUERY1 ="FROM Prospect WHERE status != 'Reject' and prospectID >=";
	
	private static final String NONREJECTED_LIST_QUERY_END = " and prospectID <=";

	private static final String ACCEPTED_LIST_QUERY = "FROM Prospect WHERE status = 'Accept'";
	
	private static final String PENDING_LIST_QUERY = "FROM Prospect WHERE status = 'Pending'";
	
	private static final String REJECTED_LIST_QUERY = "FROM Prospect WHERE status = 'Reject'";
	
	private HibernateTemplate template;
	
	//private int upperLimit, lowerLimit;
	
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
		
	}
	
	
	
	@Override
	public Prospect addProspect(Prospect prospect) {
		
		template.save(prospect);
		
		return prospect;

	}

	

	@Override
	public Prospect getProspect(int prospectID) {

		Prospect prospect = null;
		
		prospect = (Prospect)template.get(Prospect.class, prospectID);
			
		return prospect;
		
	}
	
	public Prospect updateProspect(Prospect prospect) {
		
		template.update(prospect);
		
		return prospect;
	}

	@Override
	public List<Prospect> unacceptedProspects() {
		
		@SuppressWarnings("unchecked")
		
		List<Prospect> prospectList = (List<Prospect>)template.find(ACCEPTED_NO_PROPOSAL_LIST_QUERY);
		
		return Collections.unmodifiableList(prospectList);
	}



	@Override
	public List<Prospect> acceptedProspects() {
		
		@SuppressWarnings("unchecked")
		
		List<Prospect> prospectList = (List<Prospect>) template.find(ACCEPTED_LIST_QUERY);
		
		
		return Collections.unmodifiableList(prospectList);
		
	}
	
	@Override
	public List<Prospect> pendingProspects() {
		
		@SuppressWarnings("unchecked")
		
		List<Prospect> prospectList = (List<Prospect>) template.find(PENDING_LIST_QUERY);
		
		
		return Collections.unmodifiableList(prospectList);
		
	}
	
	@Override
	public List<Prospect> rejectedProspects() {
		
		@SuppressWarnings("unchecked")
		
		List<Prospect> prospectList = (List<Prospect>) template.find(REJECTED_LIST_QUERY);
		
		
		return Collections.unmodifiableList(prospectList);
		
	}



	@Override
	public int count() {
	
		return DataAccessUtils.intResult(template.find("select count(*) from Prospect"));
		
	}
	
	public int getMaxID() {
		
		int maxID = 0;
		
		try {
		
			maxID = DataAccessUtils.intResult(template.find("select max(prospectID) from Prospect"));
			
		} catch (NullPointerException e) {
			
			return 0;
			
		}
		
		return maxID;
		
	}
	

	@Override
	public Prospect updateProposalID(int prospectID, int proposalID) {
		
		Prospect prospect= this.getProspect(prospectID);
		
		prospect.setProposalID(proposalID);
		
		this.updateProspect(prospect);
		
		return null;
	}
	
	public int acceptedProspectsCount(){

		return DataAccessUtils.intResult(template.find("select count(*) from Prospect WHERE status = 'Accept'"));
		
	}
	
	public int rejectedProspectsCount(){
		
		return DataAccessUtils.intResult(template.find("select count(*) from Prospect WHERE status = 'Reject'"));
		
	}
	
	public int pendingProspectsCount(){
		
		return DataAccessUtils.intResult(template.find("select count(*) from Prospect WHERE status = 'Pending'"));
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Prospect> listProspects() {
		List<Prospect> prospectList = null;
		
		try{
			
			prospectList = (List<Prospect>)template.find(NONREJECTED_LIST_QUERY);
			//prospectList = (List<Prospect>) DataAccessUtils.objectResult(template.find(NONREJECTED_LIST_QUERY), Prospect.class);
			
		} catch(Exception e){
			
			e.printStackTrace();
		}
		
		return prospectList;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Prospect> listViewProspects(int lowerLimit, int upperLimit) {

		System.out.println(lowerLimit+" lowerLimt "+ upperLimit + " upperLimit");
		
		List<Prospect> prospectList = null;
		
		try{
			
			prospectList = (List<Prospect>)template.find(NONREJECTED_LIST_QUERY1+lowerLimit+NONREJECTED_LIST_QUERY_END+upperLimit);
			//prospectList = (List<Prospect>) DataAccessUtils.objectResult(template.find(NONREJECTED_LIST_QUERY), Prospect.class);
			
		} catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		
		//List<Prospect> topList = getSession().createQuery(NONREJECTED_LIST_QUERY).setMaxResults(2).list();

		return Collections.unmodifiableList(prospectList);	
		
	}
	@Override
	public Prospect getProspect(String prospectName) {

		System.out.println("**1");
		List<Prospect> prospectList = listProspects();
		System.out.println("**2");
		
		Prospect prospect = new Prospect();
		System.out.println("**3");
		
		for(Prospect p : prospectList){
			System.out.println(prospectName + " : **4 : " + p.getProspectName());
			
			if(prospectName.equals(p.getProspectName())){
				
				prospect = p;
			}
		}
		System.out.println("**p : " + prospect );
		
		return prospect;
	}

}
