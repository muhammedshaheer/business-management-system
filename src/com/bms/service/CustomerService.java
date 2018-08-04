package com.bms.service;

import java.util.List;

import com.bms.domain.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public List<Customer> listCustomers();
	
	public Customer getCustomer(int customerID);
	
	public int getMaxCustomerID();

}
