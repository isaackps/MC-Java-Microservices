package com.mc.microservices.paymentservice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mc.microservices.paymentservice.entity.CardDetails;
import com.mc.microservices.paymentservice.service.BillsProxy;
import com.mc.microservices.paymentservice.service.PaymentRepository;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentController.class)
class PaymentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PaymentRepository paymentRepository;
	
	@MockBean
	private BillsProxy billsProxy;
	
	@InjectMocks
	private PaymentController paymentController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(paymentController)
				.build();
	}

	@Test
	public void getUserCardDetailsTest() throws Exception {
		
		BigInteger card_number = new BigInteger("3424323432345432");
		
		CardDetails cardDetailsMock = new CardDetails(1L, "isaac", "isaac", card_number, 321, new Date(2022/05/021));
		
		List<CardDetails> mockCardList = new ArrayList<>();
		mockCardList.add(cardDetailsMock);
		
		when(paymentRepository.findAllByUsername("isaac")).thenReturn(mockCardList);

		mockMvc.perform(get("/api/getCardDetails/{username}", "isaac"))
		.andExpect(status().isOk());
		
		verify(paymentRepository).findAllByUsername("isaac");
		
	}
	
	/*@Test
	public void payBillTest() throws Exception {
		
		String payload = "{\n" + 
				" \"id\": \"1\",\n" +
	            " \"username\": \"isaac\",\n" +
				" \"type\": \"credit card payment\",\n" +
	            " \"amount\": 100,\n" +
				" \"merchant\": \"dbs\",\n" +
				" \"status\": \"unpaid\"\n" +
				"}";
		
		mockMvc.perform(post("/api/paid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		        .andExpect(status().isOk());
		
	}*/
	
	@Test
	public void addCardDetailsTest() throws Exception {
		
		String payload = "{\n" + 
	            " \"username\": \"isaac\",\n" +
				" \"name\": \"isaac\",\n" +
	            " \"card_number\": 1003453647564563,\n" +
				" \"ccv\": 231,\n" +
				" \"expiry_date\": \"2021-01-01T00:00:00.000\"\n" +
				"}";
		
		mockMvc.perform(post("/api/addCardDetails")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		        .andExpect(status().isOk());
	}
	
	@Test
	public void deleteCardDetails() throws Exception {
				
		mockMvc.perform(delete("/api/removeCardDetails/{id}", 1L))
				.andExpect(status().isOk());
		
		
	}
	
	

}
