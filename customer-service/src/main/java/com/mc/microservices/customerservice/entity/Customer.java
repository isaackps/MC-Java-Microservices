package com.mc.microservices.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
    private String email;
    private String username;
    private String password;
    private int contact_number;
    
    protected Customer() {}
    
	public Customer(String name, String email, String username, String password, String address, String country,
			int postal_code, int contact_number) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.contact_number = contact_number;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}

	public String getPassword() {
		return password;
	}
	public int getContact_number() {
		return contact_number;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", contact_number=" + contact_number + "]";
	}
}
