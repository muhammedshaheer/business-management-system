package com.bms.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prospect")

public class Prospect {

	private Integer prospectID;
	
	private String prospectName;
	
	private Date dateOfIdentification;
	
	private String specification;
	
	private String prospectType;
	
	private String sector;
	
	private int customerID;
	
	private String source;
	
	private Date responseDeadline;
	
	private int employeeInChargeID;
	
	private String status;
	
	private String category;
	
	private String linkToFile;
	
	private Integer proposalID;
	
	private int budget;
	

	public int getBudget() {
		
		return budget;
		
	}

	public void setBudget(int budget) {
		
		this.budget = budget;
		
	}

	public Integer getProposalID() {
		
		return proposalID;
	
	}

	public void setProposalID(Integer proposalID) {
		
		this.proposalID = proposalID;
	
	}

	public Integer getProspectID() {
		
		return prospectID;
		
	}
	
	public void setProspectID(Integer prospectID) {
		
		this.prospectID = prospectID;
		
	}
	
	public String getProspectName() {
		
		return prospectName;
		
	}
	
	public void setProspectName(String prospectName) {
		
		this.prospectName = prospectName;
		
	}
	
	public Date getDateOfIdentification() {
		
		return dateOfIdentification;
		
	}
	
	public void setDateOfIdentification(Date dateOfIdentification) {
		
		this.dateOfIdentification = dateOfIdentification;
		
	}
	
	public String getSpecification() {
		
		return specification;
		
	}
	
	public void setSpecification(String specification) {
		
		this.specification = specification;
		
	}
	
	public String getProspectType() {
		
		return prospectType;
		
	}
	
	public void setProspectType(String prospectType) {
		
		this.prospectType = prospectType;
		
	}
	
	public String getSector() {
		
		return sector;
		
	}
	
	public void setSector(String sector) {
		
		this.sector = sector;
		
	}
	
	public int getCustomerID() {
		
		return customerID;
		
	}
	
	public void setCustomerID(int customerID) {
		
		this.customerID = customerID;
		
	}
	
	public String getSource() {
		
		return source;
		
	}
	
	public void setSource(String source) {
		
		this.source = source;
		
	}
	
	public Date getResponseDeadline() {
		
		return responseDeadline;
		
	}
	
	public void setResponseDeadline(Date responseDeadline) {
		
		this.responseDeadline = responseDeadline;
		
	}
	
	public int getEmployeeInChargeID() {
		
		return employeeInChargeID;
		
	}
	
	public void setEmployeeInChargeID(int employeeInChargeID) {
		
		this.employeeInChargeID = employeeInChargeID;
		
	}
	
	
	public String getStatus() {
		
		return status;
		
	}
	
	public void setStatus(String status) {
		
		this.status = status;
		
	}
	
	public String getCategory() {
		
		return category;
		
	}
	
	public void setCategory(String category) {
		
		this.category = category;
		
	}
	
	public String getLinkToFile() {
		
		return linkToFile;
		
	}
	
	public void setLinkToFile(String linkToFile) {
		
		this.linkToFile = linkToFile;
		
	}
	
	public static List<String> prospectStatus(){
		
		List<String> list= new ArrayList<String>();
		
		list.add("Accept");
		
		list.add("Reject");
		
		list.add("Pending");
		
		return Collections.unmodifiableList(list);
	}
	
	public static List<String> prospectCategory(){
		
		List<String> list= new ArrayList<String>();
		
		list.add("Hot");
		
		list.add("Warm");
		
		list.add("Cold");
		
		return Collections.unmodifiableList(list);
	}

}
