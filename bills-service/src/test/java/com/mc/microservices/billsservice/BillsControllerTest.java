package com.mc.microservices.billsservice;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.mc.microservices.billsservice.entity.Bills;
import com.mc.microservices.billsservice.service.BillsRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BillsController.class)
class BillsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BillsRepository billsRepository;
	
	@InjectMocks
	private BillsController billsController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(billsController)
				.build();
	}
	
	@Test
	public void testHelloWorld() throws Exception {
		when(billsRepository.hello()).thenReturn("hello");
		
		mockMvc.perform(get("/api"))
		.andExpect(status().isOk())
		.andExpect(content().string("hello"));
		
		verify(billsRepository).hello();
		
	}

	@Test
	public void getUserBillsTest() throws Exception {
		
		Bills bill1 = new Bills(1L, "isaac", "credit card bills", 100, "dbs", "unpaid");

		List<Bills> mockBills = new ArrayList<>();
		mockBills.add(bill1);
				
		when(billsRepository.findAllByUsername("isaac")).thenReturn(mockBills);
		
		mockMvc.perform(get("/api/get-bills/{username}", "isaac"))
		.andExpect(status().isOk());
		
		verify(billsRepository).findAllByUsername("isaac");
	}
	
	@Test
	public void addBillsTest() throws Exception {
		
		String payload = "{\n" + 
	            " \"username\": \"isaac\",\n" +
				" \"type\": \"credit card payment\",\n" +
	            " \"amount\": 100,\n" +
				" \"merchant\": \"dbs\",\n" +
				" \"status\": \"unpaid\"\n" +
				"}";
		
		mockMvc.perform(post("/api/add-bill")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		        .andExpect(status().isOk());
	}
	
	@Test
	public void payBillsTest() throws Exception {
		String payload = "{\n" + 
	            " \"id\": 1,\n" +
	            " \"username\": \"isaac\",\n" +
				" \"type\": \"credit card payment\",\n" +
	            " \"amount\": 100,\n" +
				" \"merchant\": \"dbs\",\n" +
				" \"status\": \"unpaid\"\n" +
				"}";
		
		mockMvc.perform(put("/api/paid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
				.andExpect(status().isOk());				
	}

}
