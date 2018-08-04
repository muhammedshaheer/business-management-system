package com.bms.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "requirement")

public class Requirement {

	private Integer requirementID;
	
	private Integer experience;
	
	private Integer professionalStaff;
	
	private Integer averageAnnualTurnover;
	
	private Integer prospectID;
	
	

	public Integer getRequirementID() {
		return requirementID;
	}

	public void setRequirementID(Integer requirementID) {
		this.requirementID = requirementID;
	}

	public Integer getProspectID() {
		return prospectID;
	}

	public void setProspectID(Integer prospectID) {
		this.prospectID = prospectID;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getProfessionalStaff() {
		return professionalStaff;
	}

	public void setProfessionalStaff(Integer professionalStaff) {
		this.professionalStaff = professionalStaff;
	}

	public Integer getAverageAnnualTurnover() {
		return averageAnnualTurnover;
	}

	public void setAverageAnnualTurnover(Integer averageAnnualTurnover) {
		this.averageAnnualTurnover = averageAnnualTurnover;
	}
	
	
	
}
