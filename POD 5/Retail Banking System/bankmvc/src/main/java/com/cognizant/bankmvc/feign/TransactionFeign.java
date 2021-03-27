package com.cognizant.bankmvc.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.bankmvc.model.Transaction;

@FeignClient(name = "transaction-ms", url = "${feign.url-transaction-service}")
public interface TransactionFeign {

	@GetMapping(value = "/getAllTransByAccId/{id}")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@PathVariable("id") long accId);
}
