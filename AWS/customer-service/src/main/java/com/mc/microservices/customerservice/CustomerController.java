package com.mc.microservices.customerservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.mc.microservices.customerservice.entity.Customer;
import com.mc.microservices.customerservice.service.CustomerRepository;
import com.mc.microservices.customerservice.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
    	return ResponseEntity.ok("ok");
    }
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password ) {
		Customer user = customerRepository.findByUsername(username);
		Boolean isValidCustomer = customerService.isUserValid(username, password, user);
		
		return ResponseEntity.ok(isValidCustomer);
		
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	};

	@GetMapping("/getCustomer/{username}")
	public Customer retrieveCustomer(@PathVariable String username) {
		return customerRepository.findByUsername(username);
	}
	
	@PostMapping("/register")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	};
	
	@PutMapping("/updateDetails")
	public Customer updateCustomerDetails(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}
