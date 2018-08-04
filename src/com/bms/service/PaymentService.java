package com.bms.service;

import java.util.List;

import com.bms.domain.Payment;

public interface PaymentService {

	public Payment addPayment(Payment payment);
	
	public List<Payment> listPayment();
}
