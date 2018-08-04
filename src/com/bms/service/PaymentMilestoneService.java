package com.bms.service;

import java.util.List;

import com.bms.domain.PaymentMilestone;

public interface PaymentMilestoneService {
	
	PaymentMilestone addPaymentMilestone(PaymentMilestone milestone);
	
	public List<PaymentMilestone> listMilestones();
	
	public int count();
	
	public int payedCount();
	
	public int notPayedCount();
}
