package com.returnordermanag.webPortal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.returnordermanag.webPortal.client.ComponentProcessingFeignClient;
import com.returnordermanag.webPortal.dao.ProcessReponseRepository;
import com.returnordermanag.webPortal.dao.ProcessRequestRepository;
import com.returnordermanag.webPortal.dao.UserAuthenticationRepository;
import com.returnordermanag.webPortal.model.ProcessRequest;
import com.returnordermanag.webPortal.model.ProcessResponse;

@Controller
public class ProcessController {
	
	static Logger logger = LoggerFactory.getLogger(ProcessController.class);
	
	@Autowired
	ProcessRequest processRequest;

	@Autowired
	ProcessResponse processResponse;

	@Autowired
	UserAuthenticationRepository userRepo;

	@Autowired
	ProcessRequestRepository processRequestRepo;

	@Autowired
	ProcessReponseRepository processResponseRepo;

	@Autowired
	ComponentProcessingFeignClient componentProcessingFeignClient;

	@RequestMapping("/addprocessRequest")      //To be invoked when user enters component details
	public String displayProcessingDetails(@RequestParam("username") String username,
			@RequestParam("contactNumber") long contactNumber,
			@RequestParam("componentType") String componentType, @RequestParam("componentName") String componentName,
			@RequestParam("quantityOfDefective") int quantityOfDefective,
			@RequestParam(value="isPriorityRequest",required = false)boolean isPriorityRequest,  Model model) {

		logger.info("Handling /addProcessRequest");
		
		int userId = 101;
		long creditCardNumber=1;
		processRequest = new ProcessRequest(userId, username, contactNumber, creditCardNumber,
				componentType, componentName, quantityOfDefective, isPriorityRequest);

		processRequestRepo.save(processRequest);

		String jwtToken = "Bearer "+ userRepo.findById(processRequest.getUserID()).get().getJwtToken();

		processResponse = componentProcessingFeignClient.getProcessingDetails(jwtToken, processRequest);
		processResponseRepo.save(processResponse);
		
		// Below fields to be displayed in process.jsp

		int requestId = processResponse.getRequestID();
		int userID = processResponse.getUserID();
		double processingCharge = processResponse.getProcessingCharge();
		double packagingAndDeliveryCharge = processResponse.getPackagingAndDeliveryCharge();
		String dateOfDelivery = processResponse.getDateOfDelivery();

		model.addAttribute("requestId", requestId);
		model.addAttribute("userID", userID);
		model.addAttribute("processingCharge", processingCharge);
		model.addAttribute("packagingAndDeliveryCharge", packagingAndDeliveryCharge);
		model.addAttribute("dateOfDelivery", dateOfDelivery);
		model.addAttribute("componentName",componentName);
		
		return "process.jsp";
	}
		
	@RequestMapping("/cardDetails")
	public String getCardDetails(Model map) {
		logger.info("Handling /cardDetails request");
		return "payment.jsp";
	}
	
	@RequestMapping("/payment")          
	public String confirmationMessage(@RequestParam("creditCardNumber") long userCardNumber,Model map) {
		
		logger.info("Handling /payment request");
		
		this.processRequest.setCreditCardNumber(userCardNumber);
		String response = "";
		String jwtToken = "Bearer "+ userRepo.findById(processRequest.getUserID()).get().getJwtToken();
		int requestID = processResponse.getRequestID();
		long creditCardNumber = processRequest.getCreditCardNumber();
		double totalCharge = processResponse.getProcessingCharge() + processResponse.getPackagingAndDeliveryCharge();
		
		response = componentProcessingFeignClient.paymentProcessing(jwtToken, requestID, creditCardNumber, 2000.0, totalCharge);
		
		String componentName=processRequest.getComponentName();
		String username=processRequest.getUsername();
		long creditCarNumber=processRequest.getCreditCardNumber();
		String displayCard=Long.toString(creditCarNumber).substring(0,4)+"xxxxxxxxxxxx";
		double charge=processResponse.getPackagingAndDeliveryCharge()+processResponse.getProcessingCharge();
		map.addAttribute("requestId", processResponse.getRequestID());
		map.addAttribute("response", response);
		map.addAttribute("componentName",componentName);
		map.addAttribute("username",username);
		map.addAttribute("creditCardNumber",displayCard);
		map.addAttribute("charge",charge);
		if(response.equals("Your Payment is successful. Thank you for using our service."))
			return "confirmation.jsp" ;
		return "failure.jsp";

	}
	

}
