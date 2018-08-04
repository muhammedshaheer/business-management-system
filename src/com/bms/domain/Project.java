package com.bms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {

	private Integer projectID = 1;
	
	private String projectName;
	
	private Date commencementDate;
	
	private Date completionDate;
	
	private String status;
	
	private Integer agreementID;
	
	private Integer projectHead;

	
	public Project() {
		
	}
	

	public Integer getProjectHead() {
		return projectHead;
	}


	public void setProjectHead(Integer projectHead) {
		this.projectHead = projectHead;
	}



	public String getProjectName() {
		
		return projectName;
	}

	public void setProjectName(String projectName) {
		
		this.projectName = projectName;
	}

	public Date getCompletionDate() {
		
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		
		this.completionDate = completionDate;
	}

	public String getStatus() {
		
		return status;
	}

	public void setStatus(String status) {
		
		this.status = status;
	}


	public Date getCommencementDate() {
		
		return commencementDate;
	}

	public void setCommencementDate(Date commencementDate) {
		
		this.commencementDate = commencementDate;
	}

	public Integer getAgreementID() {
		
		return agreementID;
	}

	public void setAgreementID(Integer agreementID) {
		
		this.agreementID = agreementID;
	}


	public Integer getProjectID() {
		return projectID;
	}


	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

}
