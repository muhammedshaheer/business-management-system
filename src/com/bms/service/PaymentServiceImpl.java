package com.bms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Payment;

public class PaymentServiceImpl implements PaymentService {
 
	HibernateTemplate template;
	
	public PaymentServiceImpl() {
		super();
		
	}
	
	public Payment addPayment(Payment payment){
		
		 template.save(payment);
		 
		 return payment;
		
	}
	
	public List<Payment> listPayment() {
		
		  
		@SuppressWarnings("unchecked")
		List<Payment> paymentList = template.loadAll(Payment.class);  
		    
		  return Collections.unmodifiableList(paymentList);  
		  
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
