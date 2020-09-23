package com.mc.microservices.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String username;
    private String type;
    private int amount;
    private String merchant;
    private String status;
    
    public Bills() {}
    
	public Bills(Long id, String username, String type, int amount, String merchant, String status) {
		super();
		this.id = id;
		this.username = username;
		this.type = type;
		this.amount = amount;
		this.merchant = merchant;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	public String getMerchant() {
		return merchant;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Bills [id=" + id + ", username=" + username + ", type=" + type + ", amount=" + amount + ", merchant="
				+ merchant + ", status=" + status +"]";
	}
}
