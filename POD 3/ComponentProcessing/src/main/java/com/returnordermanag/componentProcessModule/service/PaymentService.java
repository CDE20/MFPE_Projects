package com.returnordermanag.componentProcessModule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanag.componentProcessModule.client.PaymentFeignClient;
import com.returnordermanag.componentProcessModule.model.Payment;
import com.returnordermanag.componentProcessModule.repository.PaymentRepository;

@Service
public class PaymentService {
	
	static Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentFeignClient paymentFeignClient;

	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		double currentBalance = -1;
		String finalResponse ="";
		
		Payment payment = new Payment();
		payment.setRequestID(requestID);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setCreditLimit(creditLimit);
		payment.setProcessingCharge(processingCharge);
		paymentRepository.save(payment);

		logger.info("Calling Payment Microservice");
		
		currentBalance = paymentFeignClient.getCurrentBalance(creditCardNumber, processingCharge);
		
		if (currentBalance  <= -1)
			finalResponse = "We are sorry. Your payment could not be processed due to insufficient limit.";
		else
			finalResponse = "Your Payment is successful. Thank you for using our service.";

		return finalResponse;
	}

}
