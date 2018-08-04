package com.bms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "agreement")
public class Agreement {
	
	private Integer agreementId ;
	
	private Integer prospectId;
	
	private Date dateOfAgreement;
	
	private Date finishingDate;
	
	private double estimateAmount;
	
	private Integer periodOfContract;
	
	private String terminationConditions;
	
	private boolean confirm;
	
	private String linkToFile;
	
	public String getLinkToFile() {
		
		return linkToFile;
	}

	public void setLinkToFile(String linkToFile) {
		
		this.linkToFile = linkToFile;
		
	}

	public boolean isConfirm() {
		
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	
	}

	public Date getFinishingDate() {
		
		return finishingDate;
	
	}

	public void setFinishingDate(Date finishingDate) {
		
		this.finishingDate = finishingDate;
	
	}

	public Integer getPeriodOfContract() {
		
		return periodOfContract;
	
	}

	public void setPeriodOfContract(Integer periodOfContract) {
		
		this.periodOfContract = periodOfContract;
	
	}

	public String getTerminationConditions() {
	
		return terminationConditions;
	
	}

	public void setTerminationConditions(String terminationConditions) {
		
		this.terminationConditions = terminationConditions;
	
	}

	public Integer getAgreementId() {
		
		return agreementId;
	
	}
	
	public void setAgreementId(Integer agreementId) {
		
		this.agreementId = agreementId;
	
	}
	
	public Date getDateOfAgreement() {
		
		return dateOfAgreement;
	
	}
	
	public void setDateOfAgreement(Date dateOfAgreement) {
		
		this.dateOfAgreement = dateOfAgreement;
	
	}
	
	public double getEstimateAmount() {
		
		return estimateAmount;
	
	}
	
	public void setEstimateAmount(double estimateAmount) {
	
		this.estimateAmount = estimateAmount;
	
	}

	public void setProspectId(Integer prospectId) {
	
		this.prospectId = prospectId;
	
	}

	public Integer getProspectId() {
	
		return prospectId;
	
	}
	

	public void setProspectId(int prospectId) {
	
		this.prospectId = prospectId;
	
	}
	

	public void setAgreementId(int agreementId) {
	
		this.agreementId = agreementId;
	
	}

}
