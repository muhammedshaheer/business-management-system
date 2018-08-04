package com.bms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Invoice;

public class InvoiceServiceImpl implements InvoiceService {
	
	private HibernateTemplate template;

	public Invoice addInvoice(Invoice invoice){
		
		template.save(invoice);
		
		return invoice;
		
	}
	
	@Override
	public Invoice updateInvoice(Invoice invoice) {
		template.update(invoice);
		 return invoice;
	}

	@Override
	public List<Invoice> listInvoice() {
		@SuppressWarnings("unchecked")
		List<Invoice> invoiceList = template.loadAll(Invoice.class);  
		  
		 return Collections.unmodifiableList(invoiceList);
	}
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	
	}

	public InvoiceServiceImpl() {
		super();
	}



}
