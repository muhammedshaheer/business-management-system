package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Requirement;

public class EvaluateTenderAction extends AbstractAction {
	
	private static final String NEXT_PAGE = "forward:evaluateTender.jsp";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		int prospectID = Integer.parseInt(request.getParameter("prospectID"));
		
		Requirement req = new Requirement();
		
		Requirement currentStat = new Requirement();
		
		currentStat = requirementService.getCurrentStat();
		
		req = requirementService.getProspectRequirement(prospectID);
		
		int count = 0;
		
		if(currentStat.getExperience() >= req.getExperience()){
			count++;
		}
		
		if(currentStat.getProfessionalStaff() >= req.getProfessionalStaff()){
			count++;
		}
		
		if(currentStat.getAverageAnnualTurnover() >= req.getAverageAnnualTurnover()){
			count++;
		}
		
		request.setAttribute("req", req);
		
		request.setAttribute("currentStat", currentStat);
		
		request.setAttribute("count", count);
		
		request.setAttribute("total", 3);
		
		return NEXT_PAGE;
	}

}
