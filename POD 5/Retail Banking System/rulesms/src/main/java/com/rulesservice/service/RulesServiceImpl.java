package com.rulesservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rulesservice.feign.AccountFeign;
import com.rulesservice.feign.AuthorizationFeign;
import com.rulesservice.exception.AccessDeniedException;
import com.rulesservice.model.AccountInput;
import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;
import com.rulesservice.model.ServiceResponse;

@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	AuthorizationFeign authorizationFeign;

	 
 
	public boolean evaluate(RulesInput account) {
		int min=1000;
	  //if balance should higher than minimum balance
		double check = account.getCurrentBalance() - account.getAmount();
	    	if(check >= min)
	    		return true;
	    	else
	    		return false;
	}
	
	public AuthenticationResponse hasPermission(String token) {
		//validating token
		AuthenticationResponse validity = authorizationFeign.getValidity(token);
		if (!authorizationFeign.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	public ServiceResponse serviceCharges(RulesInput account) {
		ServiceResponse response=new ServiceResponse();
		response.setAccountId(account.getAccountId());
		//checking balance
		if(account.getCurrentBalance()<1000)
		{
			//if balance is lesser then minimum balance 10% detected from minimum balance
			double detected=account.getCurrentBalance()/10;
			response.setMessage("Your Balance is lesser than the minimum balance so "+detected+" is detected from your account");
			response.setBalance(account.getCurrentBalance()- detected);
		}
		else
		{
			//if minimum balance is maintained no detection occurred
			response.setMessage("No Detection");
			response.setBalance(account.getCurrentBalance());
		}
		return response;
	}


	
}
