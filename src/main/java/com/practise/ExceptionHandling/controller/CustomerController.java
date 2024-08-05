package com.practise.ExceptionHandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.practise.ExceptionHandling.entity.Customer;
import com.practise.ExceptionHandling.exception.CustomerAlreadyExistsException;
import com.practise.ExceptionHandling.exception.ErrorResponse;
import com.practise.ExceptionHandling.service.CustomerService;

@RestController 
public class CustomerController {
	
	@ExceptionHandler(value =  CustomerAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
 
    @Autowired
    private CustomerService customerService;
 
    // Get Customer by Id
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id)
    {
        return customerService.getCustomer(id);
    }
 
    // Add new Customer
    @PostMapping("/addCustomer")
    public String addcustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }
 
    // Update Customer details
    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }
}