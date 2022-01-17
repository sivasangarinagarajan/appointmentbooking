package com.appointment.appointment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointment.model.Customer;
import com.appointment.appointment.model.Serviceshop;
import com.appointment.appointment.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	
	@PostMapping
    public ResponseEntity<Customer> createShop(@Valid @RequestBody Customer customer)
     {
		Customer createcustomer = customerservice.createCustomer(customer);
        return new ResponseEntity<Customer>(createcustomer, HttpStatus.OK);
    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) 
	                                                    {
		 Customer entity = customerservice.getCustomerById(id);
	 
	        return new ResponseEntity<Customer>(entity,HttpStatus.OK);
	    }
}
