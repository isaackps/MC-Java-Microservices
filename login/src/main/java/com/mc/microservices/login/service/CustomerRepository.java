package com.mc.microservices.login.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mc.microservices.login.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long>{

}
