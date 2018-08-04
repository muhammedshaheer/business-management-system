package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Payment;
import com.bms.domain.Project;

public class ToAddMilestonePageAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:addPaymentMilestone.jsp";

	private static final String SAME_PAGE = "forward:payment.jsp";

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		

		List<Payment> paymentList = paymentService.listPayment();
		
		List<Project> projectList= projectService.listProject();

        if(!projectList.isEmpty()){
	 
        	System.out.println("project is not empty");
        	
	       request.setAttribute("projectList", projectList);

			if (!paymentList.isEmpty()) {
           
				System.out.println("payment is not empty");
				
				request.setAttribute("paymentList", paymentList);

			} 
			else {
				
				System.out.println("payment is empty");

				request.setAttribute("message", "no Projects added");

				return SAME_PAGE;
			}
        }
        else{
        	
        	System.out.println("project is empty");
        	
        	request.setAttribute("message", "no Projects Added");
        	return SAME_PAGE;
        }
		
		
		return NEXT_PAGE;

	}
}
