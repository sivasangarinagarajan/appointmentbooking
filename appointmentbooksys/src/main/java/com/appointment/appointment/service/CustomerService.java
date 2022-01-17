package com.appointment.appointment.service;

import com.appointment.appointment.model.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(String id);
	
	
}
