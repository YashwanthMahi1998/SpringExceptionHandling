package com.practise.ExceptionHandling.service;

import com.practise.ExceptionHandling.entity.Customer;

public interface CustomerService {
	
	String addCustomer(Customer customer);
	
	String updateCustomer(Customer customer);
	
	Customer getCustomer(Long id);
}
