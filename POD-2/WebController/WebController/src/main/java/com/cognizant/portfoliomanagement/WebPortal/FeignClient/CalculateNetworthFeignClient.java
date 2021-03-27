package com.cognizant.portfoliomanagement.WebPortal.FeignClient;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portfoliomanagement.WebPortal.Model.Asset;
import com.cognizant.portfoliomanagement.WebPortal.Model.SellObjectMap;



@FeignClient(name="CalculateNetWorthService",url="ec2-13-127-149-227.ap-south-1.compute.amazonaws.com" )
public interface CalculateNetworthFeignClient {
	
	@GetMapping("/NetWorth/calculateNetworth/{id}")
	public double getAsset(@RequestHeader("Authorization") String token,@PathVariable(value="id") int id);
	
	//@PostMapping("/SellAssets")
	//public double calculateBalancePostSell(@RequestBody SellObject sell)// @RequestParam
	//public List<PharmacyMedicineSupply> showList(@RequestHeader("Authorization") String token, @RequestParam String name, @RequestParam int demand);
	@GetMapping("/NetWorth/GetAllAssets/{id}")
	public List<Asset> getAllAssets(@RequestHeader("Authorization") String token,@PathVariable(value="id") int id);
	
	@PostMapping("/NetWorth/SellAssets")
	public double calculateBalancePostSellPerStock(@RequestHeader("Authorization") String token,@RequestBody SellObjectMap sell);
}
