package com.bms.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Project;

public class ViewProjectAction extends AbstractAction {

	private static final String NEXT_PAGE = "forward:viewProject.jsp";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		Project project = projectService.getProject(Integer.parseInt(request.getParameter("projectID")));
		
		request.setAttribute("project", project);
		
		return NEXT_PAGE;
		
	}

}
