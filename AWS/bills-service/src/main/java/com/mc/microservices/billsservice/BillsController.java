package com.mc.microservices.billsservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.microservices.billsservice.entity.Bills;
import com.mc.microservices.billsservice.service.BillsRepository;
import com.mc.microservices.billsservice.service.BillsService;

@RestController
@RequestMapping("/api")
public class BillsController {
	
	@Autowired
	private BillsService billsService;
	
	@Autowired
	private BillsRepository billsRepository;
	
    @GetMapping
    public String helloWorld() {
        return billsRepository.hello();
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
    	return ResponseEntity.ok("ok");
    }
	
	@GetMapping("/getBills/{username}")
    public List<Bills> retrieveBills(@PathVariable String username) {
		return billsRepository.findAllByUsername(username);
	}
	
	@PostMapping("/addBill")
	public Bills addBills(@RequestBody Bills bill) {
		return billsRepository.save(bill);
	}
	
	@PostMapping("/payBills")
	public ResponseEntity<Bills> payBills(@RequestBody PayBillDetails billDetails) {
		// check bill
		boolean paidsuccessful = billsService.checkAndPayBill(billDetails);
		
		// return true then change status to paid
		if (paidsuccessful) {
			int billId = billDetails.getBillId();
			Long billIdL = Long.valueOf(billId);
			Bills bill = billsRepository.getOne(billIdL);
			bill.setStatus("paid");
			Bills updatedBill = billsRepository.save(bill);
			return ResponseEntity.ok(updatedBill);
		}
		
		Bills emptyBill = new Bills();
		return ResponseEntity.ok(emptyBill);
			
	}

}
