package com.bms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Project;

public class ProjectServiceImpl implements ProjectService {
	
	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {

		return template;

	}
	
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
	
	}

	@Override
	public Project addProject(Project project) {
		
		System.out.println("in project service : addproject");
		
		template.save(project);
		
		System.out.println("in project service : addproject : afterr saving");
		
		return project;		
	}
	
	public List<Project> listProject() {
		
		  
		@SuppressWarnings("unchecked")
		List<Project> projectList = template.loadAll(Project.class);  
		    
		  return Collections.unmodifiableList(projectList);  
		  
	}

	@Override
	public Project getProject(int projectID) {
		
		Project project = (Project)template.get(Project.class, projectID);
		
		return project;
		
	}

	@Override
	public int count() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Project"));
	}

	@Override
	public int notYetStartedCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Project WHERE status = 'Not Started'"));
	}

	@Override
	public int inProgressCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Project WHERE status = 'In Progress'"));
	}

	@Override
	public int testingCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Project WHERE status = 'Testing'"));
	}

	@Override
	public int deployedCount() {

		return DataAccessUtils.intResult(template.find("select count(*) from Project WHERE status = 'Deployed'"));
	}

}
