package com.bms.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="paymentmilestone")
public class PaymentMilestone {

    private Integer milestoneId;
	
	private Integer paymentId;
	
	private double amount;
	
	private String description;
	
	private  Date dueDate;
	
    boolean payed;



	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public Integer getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(Integer milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	
}
