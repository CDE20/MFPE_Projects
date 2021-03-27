package com.returnordermanag.componentProcessModule.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanag.componentProcessModule.client.AuthenticationFeignClient;
import com.returnordermanag.componentProcessModule.model.AuthenticationResponse;
import com.returnordermanag.componentProcessModule.model.ProcessRequest;
import com.returnordermanag.componentProcessModule.model.ProcessResponse;
import com.returnordermanag.componentProcessModule.repository.ProcessRequestRepository;
import com.returnordermanag.componentProcessModule.service.AccessoryPartService;
import com.returnordermanag.componentProcessModule.service.IntegralPartService;
import com.returnordermanag.componentProcessModule.service.PaymentService;

@RestController
public class ComponentProcessingController {
	
	static Logger logger = LoggerFactory.getLogger(ComponentProcessingController.class);
	
	@Autowired
	IntegralPartService integralPartService;
	@Autowired
	AccessoryPartService accessoryPartService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	ProcessRequestRepository processRequestRepository;
	@Autowired
	AuthenticationFeignClient authenticationFeignClient;

	@PostMapping("/service")
	public ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token,
			@RequestBody ProcessRequest processRequest) throws Exception {
		
		logger.info("Handling /service request");
		
		AuthenticationResponse authenticationResponse = null;
		try {
			authenticationResponse = authenticationFeignClient.getValidity(token);
			boolean valid=authenticationResponse.getValid();
			if(!valid)
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		processRequestRepository.save(processRequest);
		ProcessResponse response = null;
		int userID = processRequest.getUserID();
		String componentType = processRequest.getComponentType();
		if (componentType.equals("integral"))
			response = (integralPartService.processDetail(userID));
		else if (componentType.equals("accessory"))
			response = (accessoryPartService.processDetail(userID));
		return response;
	}

	@PostMapping("/payment/{requestID}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	public String paymentProcessing(@RequestHeader("Authorization") String token,
			@PathVariable("requestID") int requestID, @PathVariable("creditCardNumber") long creditCardNumber,
			@PathVariable("creditLimit") double creditLimit,
			@PathVariable("processingCharge") double processingcharge) throws Exception {
		
		logger.info("Processing the order");
		
		AuthenticationResponse authenticationResponse = null;
		try {	
			authenticationResponse = authenticationFeignClient.getValidity(token);
			if(!authenticationResponse.getValid())
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		return paymentService.completeProcessing(requestID, creditCardNumber, creditLimit, processingcharge);
	}
}
