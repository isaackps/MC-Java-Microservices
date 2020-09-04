package com.mc.microservices.billsservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mc.microservices.billsservice.entity.Bills;

public interface BillsRepository extends JpaRepository<Bills, Long> {

	public List<Bills> findAllByUsername(@Param("username") String username);
}
