package com.bms.service;

import java.util.List;

import com.bms.domain.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> listEmployees();
	
	public Employee getEmployee(String employeeID);
	
	public int adminUserCount();
	
	public int salesUserCount();
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> listSeniorEmployees();
	
	public List<Employee> listSalesEmployees();
	
	public List<Employee> listManagerEmployees();
	
	public int count();
	
	public int seniorOfficersCount();
	
	public int salesCount();
	
	public int managersCount();

}
