package com.practise.ExceptionHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.ExceptionHandling.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByName(String name);
}
