package com.mc.microservices.billsservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mc.microservices.billsservice.entity.Bills;
import com.mc.microservices.billsservice.service.BillsRepository;

@RestController
public class billsController {
	
	@Autowired
	private BillsRepository billsRepository;
	
	@GetMapping("/get-bills/{username}")
    public List<Bills> retrieveBills(@PathVariable String username) {
		return billsRepository.findAllByUsername(username);
	}
	
	@PostMapping("/add-bill")
	public Bills addBills(@RequestBody Bills bill) {
		return billsRepository.save(bill);
	}
	
	@PutMapping("/paid")
	public ResponseEntity<Bills> payBills(@RequestBody Bills bill) {
		bill.setStatus("paid");
		final Bills updatedBill = billsRepository.save(bill);
		return ResponseEntity.ok(updatedBill);
	}

}
