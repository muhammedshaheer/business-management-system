package com.bms.service;

import java.util.List;

import com.bms.domain.Invoice;

public interface InvoiceService {
	
	public Invoice addInvoice(Invoice invoice);
	
	public Invoice updateInvoice(Invoice invoice);
	
	public List<Invoice> listInvoice();
	
}
