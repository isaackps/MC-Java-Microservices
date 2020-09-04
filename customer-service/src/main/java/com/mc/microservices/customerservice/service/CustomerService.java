package com.mc.microservices.customerservice.service;

import org.springframework.stereotype.Component;

import com.mc.microservices.customerservice.entity.Customer;

@Component
public class CustomerService {
	public boolean isUserValid(String username, String password, Customer customer) {
		if (customer == null) {
			return false;
		}
		if (customer.getPassword().equals(password) && customer.getUsername().equals(username)) {
			System.out.print(customer + customer.getPassword() + customer.getUsername());
			return true;
		}
		return false;
	}
}
