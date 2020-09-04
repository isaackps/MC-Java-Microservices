package com.mc.microservices.customerservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mc.microservices.customerservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByUsername(@Param("username") String username);
}
