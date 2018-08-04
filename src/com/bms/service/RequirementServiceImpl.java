package com.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Requirement;

public class RequirementServiceImpl implements RequirementService {
	
	private HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
		
	}
	
	
	
	public HibernateTemplate getTemplate() {
		
		return template;
	}



	@Override
	public Requirement addRequirement(Requirement requirement) {
		
		System.out.println("inside add");
		
		System.out.println(template);
		
		template.save(requirement);
		
		System.out.println("after save");
		
		return requirement;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Requirement getProspectRequirement(int prospectID) {
		
		Requirement req = null;
		
		List<Requirement> reqList = new ArrayList<Requirement>();
		
		reqList = (List<Requirement>)(Object)template.find("FROM Requirement WHERE prospectID = '" + prospectID + "'");
		
		req = reqList.get(0);
		
		return req;
		
	}
	
	@Override
	public Requirement getCurrentStat() {
		
		Requirement req = null;
		
		req = (Requirement)template.get(Requirement.class, 1);
		
		return req;
		
	}

}
