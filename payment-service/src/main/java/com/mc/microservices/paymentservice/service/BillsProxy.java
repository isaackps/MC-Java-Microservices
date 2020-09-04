package com.mc.microservices.paymentservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mc.microservices.paymentservice.entity.Bills;

@FeignClient(name="api-gateway-server")
@RibbonClient(name="bills-service")
public interface BillsProxy {
	@PutMapping("/bills-service/paid")
	public ResponseEntity<Bills> payBills(@RequestBody Bills bill);
}
