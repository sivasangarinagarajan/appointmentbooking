package com.appointment.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.appointment.model.Customer;
import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerrepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerrepo.save(customer);
	}
	@Override
	public Customer getCustomerById(String id) {
		// TODO Auto-generated method stub
		  return customerrepo.findById(id).get();
	}
	
}
