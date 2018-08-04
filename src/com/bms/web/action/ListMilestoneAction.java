package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Payment;
import com.bms.domain.PaymentMilestone;
import com.bms.domain.Project;

public class ListMilestoneAction extends AbstractAction {


	private static final String NEXT_PAGE = "forward:listPaymentMilestone.jsp";

	private static final String MILESTONE_LIST = "milestoneList";
	
	private static final String PROJECT_LIST="projectList";
	
	private static final String PAYMENT_LIST="paymentList";



	public String execute(HttpServletRequest request,HttpServletResponse response) {

		List<PaymentMilestone> milestoneList = paymentMilestoneService.listMilestones();
		
		List<Project> projectList=projectService.listProject();
		
		List<Payment> paymentList=paymentService.listPayment();
		
		

		
        if (!(milestoneList.isEmpty())) {
			
			request.setAttribute(MILESTONE_LIST, milestoneList);
			
			request.setAttribute(PROJECT_LIST, projectList);
			
			request.setAttribute(PAYMENT_LIST, paymentList);
		}

		else {
		}
 System.out.println(NEXT_PAGE);
		return NEXT_PAGE;
	}
	


}
