package com.mc.microservices.login.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mc.microservices.login.entity.Customers;
import com.mc.microservices.login.service.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customers> retrieveAllCustomers() {
		return customerRepository.findAll();
	};
	
	@PostMapping("/register")
	public Customers addCustomer(@RequestBody Customers customer) {
		System.out.println("saved!" + customer);
		//Customers savedCustomer = customerRepository.save(customer);
		return customerRepository.save(customer);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//		.buildAndExpand(savedCustomer.getId()).toUri();

		//return ResponseEntity.created(location).build();
	};
	
	
}
