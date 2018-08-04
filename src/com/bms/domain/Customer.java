package com.bms.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")

public class Customer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Integer customerID;
	
	private String customerName;
	
	private String contactPerson;
	
	private String customerEmailID;
	
	private String customerPhone;

	public Integer getCustomerID() {
		
		return customerID;
		
	}

	public void setCustomerID(Integer customerID) {
		
		this.customerID = customerID;
		
	}

	public String getCustomerName() {
		
		return customerName;
		
	}

	public void setCustomerName(String customerName) {
		
		this.customerName = customerName;
		
	}

	public String getContactPerson() {
		
		return contactPerson;
		
	}

	public void setContactPerson(String contactPerson) {
		
		this.contactPerson = contactPerson;
		
	}

	public String getCustomerEmailID() {
		
		return customerEmailID;
		
	}

	public void setCustomerEmailID(String customerEmailID) {
		
		this.customerEmailID = customerEmailID;
		
	}

	public String getCustomerPhone() {
		
		return customerPhone;
		
	}

	public void setCustomerPhone(String customerPhone) {
		
		this.customerPhone = customerPhone;
		
	}
	
}
