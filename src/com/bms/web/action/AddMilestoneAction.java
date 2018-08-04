package com.bms.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Invoice;
import com.bms.domain.PaymentMilestone;

public class AddMilestoneAction extends AbstractAction {
 
	private static final String NEXT_PAGE = "redirect:listMilestone.do";
	
	private static final String NULL_INPUT="";
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
	PaymentMilestone paymentmilestone= milestoneFromRequest(request);
        

		if (null != paymentmilestone) {

		PaymentMilestone milestone=paymentMilestoneService.addPaymentMilestone(paymentmilestone);
		
		Invoice invoice= new Invoice();
		
		invoice.setMilestoneId(milestone.getMilestoneId());
		
		invoiceService.addInvoice(invoice);
		

	     request.setAttribute("message", "Payment Milestone added");
			

		} else {
			
			throw new RuntimeException("couldn't add Payment Milestone");

		}

		return NEXT_PAGE;
	}

	

	private PaymentMilestone milestoneFromRequest(HttpServletRequest request) {

		PaymentMilestone milestone = new PaymentMilestone();

		String paymentId = request.getParameter("paymentId");

		String DD= request.getParameter("dueDate");

		String amount = request.getParameter("amount");


		String description = request.getParameter("description");

		if (paymentId != NULL_INPUT && DD!= NULL_INPUT && amount != NULL_INPUT && description != NULL_INPUT ) {
			
			milestone.setPaymentId(Integer.parseInt(paymentId));
			
			milestone.setAmount(Double.parseDouble(amount));
			
			milestone.setDescription(description);
			
			milestone.setPayed(Boolean.getBoolean(request.getParameter("payed")));
	
				
				Date dueDate;
				try {
					dueDate = new SimpleDateFormat(DATE_FORMAT).parse(DD);
					milestone.setDueDate(dueDate);
				} catch (java.text.ParseException e) {
                 e.printStackTrace();
				}

				

			} 

		else{
			throw new RuntimeException("invalid inputs");
		}
		return milestone;
	}
	
	}


