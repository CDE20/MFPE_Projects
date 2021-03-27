package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.MutualFundDetails;

@FeignClient(name="DailyMutualFundService",url="ec2-65-1-114-36.ap-south-1.compute.amazonaws.com")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyAllMutualFundNav")
	public List<MutualFundDetails> getAllMututalFunds(@RequestHeader("Authorization") String token);
	
	@GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundName") String mutualFundName);
	
	@GetMapping("/dailyMutualFundNav/{mutualFundIdList}")
	public List<Double> getMutualDetailsById(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundIdList") List<String> mutualFundId);

}
