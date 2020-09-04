package com.mc.microservices.paymentservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mc.microservices.paymentservice.entity.CardDetails;

public interface PaymentRepository extends JpaRepository<CardDetails, Long>{

	public List<CardDetails> findAllByUsername(@Param("username") String username);
}
