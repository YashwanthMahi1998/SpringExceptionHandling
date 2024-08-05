package com.practise.ExceptionHandling.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.ExceptionHandling.entity.Customer;
import com.practise.ExceptionHandling.exception.CustomerAlreadyExistsException;
import com.practise.ExceptionHandling.exception.NoSuchCustomerException;
import com.practise.ExceptionHandling.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addCustomer(Customer customer) {
		Customer customer2=customerRepository.findByName(customer.getName());
		if(customer2!=null) {
			throw new CustomerAlreadyExistsException("Customer already exists!!");
		}
		else {
			 customerRepository.save(customer);
			 return "Customer added successfully";
		}
		
	}

	@Override
	public String updateCustomer(Customer customer) {
		Customer updateCustomer=new Customer();
		Optional<Customer> customer2=customerRepository.findById(customer.getId());
		if(customer2.isPresent()) {
			updateCustomer.setName(customer.getName());
			updateCustomer.setAddress(customer.getAddress());
			customerRepository.save(updateCustomer);
			return "Record Updated Successfully";
		}
		else {
			throw new NoSuchCustomerException("No such customer exists ");
		}
		
	}

	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isEmpty()) {
			throw new NoSuchElementException("No such customer exists with id:"+id);
		}
		else {
			return customer.get();
		}
		
	}

}
