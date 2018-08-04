package com.bms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.PaymentMilestone;

public class PaymentMilestoneServiceImpl implements PaymentMilestoneService {
       
	private HibernateTemplate template;
	
	public PaymentMilestoneServiceImpl() {
		
		super();
		
	}
	
	public PaymentMilestone addPaymentMilestone(PaymentMilestone milestone){
		
		try{
		template.save(milestone);}
		
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return milestone;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<PaymentMilestone> listMilestones() {
		
		  List<PaymentMilestone> milestoneList = template.loadAll(PaymentMilestone.class);  
		    
		  return Collections.unmodifiableList(milestoneList);  
		  
	}

	public HibernateTemplate getTemplate() {
		
		return template;
	
	}

	public void setTemplate(HibernateTemplate template) {
	
		this.template = template;
	
	}

	@Override
	public int count() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from PaymentMilestone"));
	}

	@Override
	public int payedCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from PaymentMilestone WHERE payed=true"));
	}

	@Override
	public int notPayedCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from PaymentMilestone WHERE payed=false"));
	}
	
}
