package com.bms.service;

import java.util.List;

import com.bms.domain.Project;

public interface ProjectService {

	public Project addProject(Project project);
	
	public List<Project> listProject();
	
	public Project getProject(int projectID);
	
	public int count();
	
	public int notYetStartedCount();
	
	public int inProgressCount();
	
	public int testingCount();
	
	public int deployedCount();
}
