package com.mc.microservices.paymentservice.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String name;
	private BigInteger card_number;
	private int ccv;
	private Date expiry_date;
	
	public CardDetails() {}

	public CardDetails(Long id, String username, String name, BigInteger card_number, int ccv, Date expiry_date) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.card_number = card_number;
		this.ccv = ccv;
		this.expiry_date = expiry_date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getCard_number() {
		return card_number;
	}

	public void setCard_number(BigInteger card_number) {
		this.card_number = card_number;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	
	
}
