package com.bms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bms.domain.Customer;


public class CustomerServiceImpl implements CustomerService {
	
	private HibernateTemplate template;
	
	
	
	public void setTemplate(HibernateTemplate template) {
		
		this.template = template;
		
	}

	public Customer addCustomer(Customer customer) {
		
		
		template.saveOrUpdate(customer);
		
		return customer;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		
		List<Customer> customerList = new ArrayList<Customer>();

		customerList = template.loadAll(Customer.class);

		return Collections.unmodifiableList(customerList);
		
	}

	@Override
	public Customer getCustomer(int customerID) {
		
		Customer customer = null;
		
		customer = (Customer)template.get(Customer.class, customerID);
			
		return customer;
		
	}
	
	public int getMaxCustomerID() {
		
		int maxID=0;
		
		@SuppressWarnings("unchecked")
		List<Customer> customerList = (List<Customer>)template.find("FROM Customer WHERE customerID IN(SELECT MAX(customerID) FROM Customer)");
		
		for(Customer customer:customerList){
			
			maxID = customer.getCustomerID();
			
		}
		
		return maxID;
	}

}
