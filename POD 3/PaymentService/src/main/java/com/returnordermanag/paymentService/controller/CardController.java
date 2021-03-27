package com.returnordermanag.paymentService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanag.paymentService.exception.CardNotFoundException;
import com.returnordermanag.paymentService.service.CardService;

@RestController
public class CardController {
	
	static Logger logger = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardService cardService;
	
	
	@GetMapping("/card/{cardNumber}/{charge}")
	@ResponseStatus(code=HttpStatus.OK)
	public double getBalance(@PathVariable long cardNumber,@PathVariable double charge) throws CardNotFoundException {
		logger.info("Handling /card/{cardNumber}/{charge}");
		try {
			return cardService.processPayment(cardNumber,charge);
		}
		catch(CardNotFoundException ex){
			throw new CardNotFoundException();
		}
		
	}
}
