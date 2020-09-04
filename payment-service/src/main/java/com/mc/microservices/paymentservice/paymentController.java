package com.mc.microservices.paymentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mc.microservices.paymentservice.entity.Bills;
import com.mc.microservices.paymentservice.entity.CardDetails;
import com.mc.microservices.paymentservice.service.BillsProxy;
import com.mc.microservices.paymentservice.service.PaymentRepository;

@RestController
public class paymentController {
	
	@Autowired
	private BillsProxy billsProxy;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@GetMapping("/get-card-details/{username}")
	public List<CardDetails> getUserCardDetails(@PathVariable String username) {
		return paymentRepository.findAllByUsername(username);
	}

	@PostMapping("/paid")
	public void payBill(@RequestBody Bills billDetails) {
		//new RestTemplate().put("http://localhost:8000/paid", billDetails);
		billsProxy.payBills(billDetails);
	}
	
	@PostMapping("/add-card-details")
	public CardDetails addCardDetails(@RequestBody CardDetails cardDetails) {
		return paymentRepository.save(cardDetails);
	}
	
	@DeleteMapping("/remove-card-details/{id}")
	public ResponseEntity<String> deleteCard(@PathVariable Long id) {
		paymentRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
