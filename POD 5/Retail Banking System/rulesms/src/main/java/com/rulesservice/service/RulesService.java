package com.rulesservice.service;

import com.rulesservice.model.AuthenticationResponse;
import com.rulesservice.model.RulesInput;
import com.rulesservice.model.ServiceResponse;

public interface RulesService {
	
	public boolean evaluate(RulesInput account);
	
	public AuthenticationResponse hasPermission(String token);
	
	public ServiceResponse serviceCharges(RulesInput account);
	
}
