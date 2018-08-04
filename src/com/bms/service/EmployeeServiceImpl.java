package com.bms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private HibernateTemplate template;
	
	private static final String SENIOR_LIST_QUERY = "FROM Employee WHERE designation = 'CEO' OR designation = 'CTO' OR designation = 'CFO'";
	
	private static final String SALES_LIST_QUERY = "FROM Employee WHERE designation = 'Sales Executive' OR designation = 'sales'";
	
	private static final String MANAGER_LIST_QUERY = "FROM Employee WHERE designation = 'Managers'";
	
	public EmployeeServiceImpl() {

	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		template.save(employee);
		
		return employee;
	}
	
	@Override
	public Employee getEmployee(String employeeID) {
		
		Employee employee = null;
		
		employee = (Employee)template.get(Employee.class, employeeID);
			
		return employee;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		list = template.loadAll(Employee.class);
		
		return Collections.unmodifiableList(list);
	}

	public HibernateTemplate getTemplate() {
		
		return template;
	
	}

	public void setTemplate(HibernateTemplate template) {
	
		this.template = template;
	
	}

	@Override
	public int adminUserCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from UserRoles WHERE role_name = 'admin'"));
		
	}

	@Override
	public int salesUserCount() {

		return DataAccessUtils.intResult(template.find("select count(*) from UserRoles WHERE role_name = 'sales'"));
		
	}
	
	public Employee updateEmployee(Employee employee) {
		
		template.update(employee);
		
		return employee;
		
	}
	
	@Override
	public List<Employee> listSeniorEmployees() {
		
		@SuppressWarnings("unchecked")
		
		List<Employee> employeeList = (List<Employee>) template.find(SENIOR_LIST_QUERY);
		
		return Collections.unmodifiableList(employeeList);
		
	}
	
	@Override
	public List<Employee> listSalesEmployees() {
		
		@SuppressWarnings("unchecked")
		
		List<Employee> employeeList = (List<Employee>) template.find(SALES_LIST_QUERY);
		
		return Collections.unmodifiableList(employeeList);
		
	}
	
	@Override
	public List<Employee> listManagerEmployees() {
		
		@SuppressWarnings("unchecked")
		
		List<Employee> employeeList = (List<Employee>) template.find(MANAGER_LIST_QUERY);
		
		return Collections.unmodifiableList(employeeList);
		
	}

	@Override
	public int count() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Employee"));
	}

	@Override
	public int seniorOfficersCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Employee WHERE designation = 'CEO' OR designation = 'CTO' OR designation = 'CFO'"));
	}

	@Override
	public int salesCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Employee WHERE designation = 'Sales Executive' OR designation = 'sales'"));
	}

	@Override
	public int managersCount() {
		
		return DataAccessUtils.intResult(template.find("select count(*) from Employee WHERE designation = 'Managers'"));
	}

}
