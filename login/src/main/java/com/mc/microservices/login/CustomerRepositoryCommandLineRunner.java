package com.mc.microservices.login;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mc.microservices.login.entity.Customers;
import com.mc.microservices.login.service.CustomerRepository;

@Component
public class CustomerRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CustomerRepositoryCommandLineRunner.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
        //Customer customer = new Customer("Jav", "dav@gmail.com", "dav", "12345", "singapore", "singapore", 543423, 87654321);	
	    //customerRepository.save(customer);
		 List<Customers> customers = customerRepository.findAll();
	    
	    log.info("Able to get all custoemrs: " + customers);
	}

}
