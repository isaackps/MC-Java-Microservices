package com.mc.microservices.paymentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mc.microservices.paymentservice.service.BillsProxy;

@SpringBootTest
class PaymentServiceApplicationTests {
	
	@MockBean
	private BillsProxy billsProxy;

	@Test
	void contextLoads() {
	}

}
