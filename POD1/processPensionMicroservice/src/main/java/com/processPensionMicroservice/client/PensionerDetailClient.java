package com.processPensionMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.processPensionMicroservice.model.PensionerDetail;

@FeignClient(name = "PensionerDetailsService", url = "http://localhost:8082/")
public interface PensionerDetailClient {
	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber);
}