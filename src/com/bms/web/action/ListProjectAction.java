package com.bms.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.domain.Project;

public class ListProjectAction extends AbstractAction {
	
	private static final String NEXT_PAGE = "forward:listProject.jsp";

	private static final String PROJECT_LIST = "projectList";

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		List<Project> projectList = projectService.listProject();

		if (!(projectList.isEmpty())) {

			request.setAttribute(PROJECT_LIST, projectList);
		}

		else {
			
			request.setAttribute("message", "No projects");
		}

		return NEXT_PAGE;
	}

}
