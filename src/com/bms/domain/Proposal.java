package com.bms.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "proposal")
public class Proposal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer proposalID;
	
	private String proposalName;

	private String description;
	
	private Date dateOfAcceptance;
	
	private Date dateOfModification;
	
	private String linkToFile;
	
	private Integer prospectID;
	
	private String status;

	public String getStatus() {
		
		return status;
	
	}

	public void setStatus(String status) {
		
		this.status = status;
	
	}

	public Integer getProspectID() {
		
		return prospectID;
	
	}

	public void setProspectID(Integer prospectID) {
		
		this.prospectID = prospectID;
	
	}

	public Integer getProposalID() {
		
		return proposalID;
		
	}

	public void setProposalID(Integer proposalID) {
		
		this.proposalID = proposalID;
		
	}

	public String getDescription() {
		
		return description;
		
	}
	
	public String getProposalName() {
		
		return proposalName;
		
	}

	public void setProposalName(String proposalName) {
		
		this.proposalName = proposalName;
		
	}

	public void setDescription(String description) {
		
		this.description = description;
		
	}

	public Date getDateOfAcceptance() {
		
		return dateOfAcceptance;
		
	}

	public void setDateOfAcceptance(Date dateOfAcceptance) {
		
		this.dateOfAcceptance = dateOfAcceptance;
		
	}

	public Date getDateOfModification() {
		
		return dateOfModification;
		
	}

	public void setDateOfModification(Date dateOfModification) {
		
		this.dateOfModification = dateOfModification;
		
	}

	public String getLinkToFile() {
		
		return linkToFile;
		
	}

	public void setLinkToFile(String linkToFile) {
		
		this.linkToFile = linkToFile;
		
	}
	
	
	

}
