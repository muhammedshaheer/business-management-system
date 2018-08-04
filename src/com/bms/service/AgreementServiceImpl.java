package com.bms.service;

import java.util.Collections; 
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Agreement;

public class AgreementServiceImpl implements AgreementService {
    

	private HibernateTemplate template;
	
	public AgreementServiceImpl() {
		
		super();
	}

	public Agreement addAgreement(Agreement agreement) {
		try{
			
		template.save(agreement);
		
		}
		catch (Exception e){
			
			e.printStackTrace();
			
			throw new RuntimeException("Coundn't add agreement into database");
			
			}

		return agreement;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Agreement> listAgreements() {
		
		 List<Agreement> agreementList = template.loadAll(Agreement.class);  
		  
		 return Collections.unmodifiableList(agreementList);  
		  
	}
	
	@Override
	public Agreement getAgreement(int agreementId) {
		
	
		Agreement agreement =(Agreement) template.get(Agreement.class,agreementId);
		
		return agreement;
		
	}
	
	@Override
	public int getAgreementId(String prospectName) {
		
		String query = "SELECT agreementId FROM Agreement WHERE prospectId IN (SELECT prospectID FROM Prospect WHERE prospectName = '" + prospectName + "')";

		List<Integer> agreementId =(List<Integer>) template.find(query);
		
		//System.out.println("in gett agreement id : " + agreementId.get(0));
		
		return agreementId.get(0);
	}
	
	
	@Override
	public List<Integer> getAvailableAgreements(){
		
		String query = "SELECT agreementId FROM Agreement WHERE agreementId NOT IN (SELECT agreementID FROM Project)";

		List<Integer> agreementIds =(List<Integer>) template.find(query);
		
		return agreementIds;

	}
	
	public Agreement updateAgreement(Agreement agreement) {
		
		template.update(agreement);
		
		return agreement;
	}
	
	public int getMaxID() {
		
		int maxID = 0;
		
		try {
		
			maxID = DataAccessUtils.intResult(template.find("select max(agreementId) from Agreement"));
			
		} catch(NullPointerException e){
			
			return 0;
			
		}
		
		return maxID;
		
	}
	
	public HibernateTemplate getTemplate() {
		
		return template;
		
	}
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
		
	}
	
	@Override
	public int confirmedAgreementCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Agreement WHERE confirm = true"));
	}

	@Override
	public int notConfirmedAgreementCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Agreement WHERE confirm = false"));
	}

	@Override
	public int count() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Agreement"));
	
	}
	
	

}
