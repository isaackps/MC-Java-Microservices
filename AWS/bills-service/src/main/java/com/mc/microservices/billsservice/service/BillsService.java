package com.mc.microservices.billsservice.service;

import org.springframework.stereotype.Component;

import com.mc.microservices.billsservice.PayBillDetails;

@Component
public class BillsService {
	public boolean checkAndPayBill(PayBillDetails payBillDetails) {
		
		//mock check and return true if all fields are present
		String username = payBillDetails.getUsername();
		int billId = payBillDetails.getBillId();
		int cardId = payBillDetails.getCardId();
		
		if (username.length() > 0 && billId > 0 && cardId > 0) {
			return true;
		}	
		
		return false;
	}
}
