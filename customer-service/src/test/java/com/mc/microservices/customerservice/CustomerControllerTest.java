package com.mc.microservices.customerservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mc.microservices.customerservice.entity.Customer;
import com.mc.microservices.customerservice.service.CustomerRepository;
import com.mc.microservices.customerservice.service.CustomerService;

import ch.qos.logback.core.status.Status;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CustomerRepository customerRepository;
	
	@MockBean
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerController customerController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerController)
				.build();
	}
	
	@Test
	void loginTest() throws Exception {
		
		Customer customer = new Customer("isaac", "isaac@gmail.com", "isaac", "12345", 98765432);
		customer.setId(1L);
		
		when(customerRepository.findByUsername("isaac")).thenReturn(customer);
		when(customerService.isUserValid("isaac", "12345", customer)).thenReturn(true);
		
		mockMvc.perform(post("/api/login")
				.param("username", "isaac")
				.param("password", "12345"))
				.andExpect(status().isOk());
	}
	
	@Test
	void retrieveAllCustomersTest() throws Exception {
		
		mockMvc.perform(get("/api/get-all-customer")).andExpect(status().isOk());
		
	}
	
	@Test
	void retrieveCustomerTest() throws Exception {
		
		Customer customer = new Customer("isaac", "isaac@gmail.com", "isaac", "12345", 98765432);
		
		when(customerRepository.findByUsername("isaac")).thenReturn(customer);
		
		mockMvc.perform(get("/api/get-customer/{username}", "isaac")).andExpect(status().isOk());
		
	}
	
	@Test
	void addCustomerTest() throws Exception {
		
		String payload = "{\n" + 
	            " \"name\": \"isaac\",\n" +
				" \"email\": \"isaac@gmail.com\",\n" +
	            " \"username\": \"isaac\",\n" +
				" \"password\": \"12345\",\n" +
				" \"contact_number\": 98765432\n" +
				"}";
		
		mockMvc.perform(post("/api/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		        .andExpect(status().isOk());
		
	}
	
	@Test
	void updateCustomerDetailsTest() throws Exception {
		String payload = "{\n" + 
	            " \"id\": 1,\n" +
	            " \"name\": \"isaac\",\n" +
				" \"email\": \"isaac@gmail.com\",\n" +
	            " \"username\": \"isaac\",\n" +
				" \"password\": \"12345\",\n" +
				" \"contact_number\": 98765432\n" +
				"}";
		
		mockMvc.perform(put("/api/update-details")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
				.andExpect(status().isOk());
		
	}
	
	
	
	
	
	
	

}
