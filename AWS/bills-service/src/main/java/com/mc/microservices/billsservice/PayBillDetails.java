package com.mc.microservices.billsservice;

public class PayBillDetails {
	private String username;
	private int billId;
	private int cardId;
	
	public PayBillDetails() {};
	
	public PayBillDetails(String username, int billId, int cardId) {
		super();
		this.username = username;
		this.billId = billId;
		this.cardId = cardId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getBillId() {
		return billId;
	}
	
	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}


	
}
