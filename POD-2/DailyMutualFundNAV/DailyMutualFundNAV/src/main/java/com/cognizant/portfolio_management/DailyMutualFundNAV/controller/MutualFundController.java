package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.service.MutualFundService;

@RestController
public class MutualFundController {
	
	
	@Autowired
	private MutualFundService service;
	
	@GetMapping("/dailyAllMutualFundNav")
	public ResponseEntity<List<MutualFund>> getAllMutualFund(@RequestHeader("Authorization") String token){
		try {
		if(service.isSessionValid(token)) {
			//return service.getAllMutualFund();
			return ResponseEntity.ok(service.getAllMutualFund());
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}catch(Throwable e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	@GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
	public MutualFund getDailyMutualFundNav(@RequestHeader("Authorization") String token,@PathVariable String mutualFundName) throws MutualFundNotFoundException{
		if(service.isSessionValid(token)) {
			return service.getMutualFundByName(mutualFundName);
		}
		return null;
	}
	
	@GetMapping("/dailyMutualFundNav/{mutualFundId}")
	public List<Double> getDailyMutualFundNavById(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundId") List<String> mutualFundIdList) throws MutualFundNotFoundException{
		if(service.isSessionValid(token)) {
			return service.getMutualFundByIdList(mutualFundIdList);
		}
		return null;
	}
}
