package com.bms.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	private String employeeID;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String Designation;

	public String getEmployeeID() {
		
		return employeeID;
	
	}

	public void setEmployeeID(String id) {
	
		this.employeeID = id;
	
	}

	public String getFirstName() {
	
		return firstName;
	
	}

	public void setFirstName(String firstName) {
	
		this.firstName = firstName;
	
	}

	public String getLastName() {
	
		return lastName;
	
	}

	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	
	}

	public String getEmailId() {
	
		return emailId;
	
	}

	public void setEmailId(String emailId) {
	
		this.emailId = emailId;
	
	}

	public String getPhoneNumber() {
	
		return phoneNumber;
	
	}

	public void setPhoneNumber(String phoneNumber) {
	
		this.phoneNumber = phoneNumber;
	
	}

	public String getDesignation() {
	
		return Designation;
	
	}

	public void setDesignation(String designation) {
	
		Designation = designation;
	
	}
	
	public static List<String> employeeDesignation(){
		
		List<String> list= new ArrayList<String>();
		
		list.add("CEO");
		
		list.add("CTO");
		
		list.add("CFO");
		
		list.add("Sales Executive");
		
		list.add("sales");
		
		list.add("Managers");
		
		return Collections.unmodifiableList(list);
		
	}
	
}
