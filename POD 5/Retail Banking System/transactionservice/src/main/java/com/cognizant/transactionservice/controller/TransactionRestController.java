package com.cognizant.transactionservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.transactionservice.feign.AccountFeign;
import com.cognizant.transactionservice.feign.RulesFeign;
import com.cognizant.transactionservice.models.Transaction;
import com.cognizant.transactionservice.repository.TransactionRepository;
import com.cognizant.transactionservice.service.TransactionServiceInterface;
import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TransactionRestController {

	public static final String METHOD_FOR_MAKETRANSFER = "AccountFallbackForTransfer";
	public static final String METHOD_FOR_MAKEWITHDRAW = "AccountFallbackForWithdraw";
	public static final String METHOD_FOR_MAKEDEPOSIT = "AccountFallbackForDeposit";

	@Autowired
	AccountFeign accountFeign;

	@Autowired
	RulesFeign rulesFeign;

	@Autowired
	TransactionRepository transRepo;

	@Autowired
	TransactionServiceInterface transactionService;

	/*
	 * MakeTransfer method Transfers amount from One account to another
	 */
	@PostMapping(value = "/transactions")
	public boolean makeTransfer(@RequestHeader("Authorization") String token,
			@Valid @RequestBody TransactionInput transactionInput) {
		log.info("inside transaction method");
		if (transactionInput != null) {
			boolean isComplete = transactionService.makeTransfer(token, transactionInput);
			
			return isComplete;
		} else {
			return false;
		}
	}

	/*
	 * Fallback method for transfer
	 */
	public boolean accountFallbackForTransfer() {
		log.error("Account Microservice is DOWN!");
		return false;
	}

	/*
	 * To get All transaction done in one account
	 */
	@GetMapping(value = "/getAllTransByAccId/{id}")
	public List<Transaction> getTransactionsByAccId(@RequestHeader("Authorization") String token,
			@PathVariable("id") long accId) {
		List<Transaction> slist = transRepo.findBySourceAccountIdOrTargetAccountIdOrderByInitiationDate(accId, accId);
		return slist;
	}

	/*
	 * Method for making a withdraw in one account
	 */
	@PostMapping(value = "/withdraw")
	public boolean makeWithdraw(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInput accountInput){
		transactionService.makeWithdraw(token, accountInput);
		return true;
	}
	
	@PostMapping(value = "/servicecharge")
	public boolean makeServiceCharges(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInput accountInput) {
		transactionService.makeServiceCharges(token, accountInput);
		return true;
	}

	/*
	 * Fallback method for Withdraw
	 */
	public boolean accountFallbackForWithdraw() {
		log.error("Rules Microservice is DOWN!");
		return false;
	}

	/*
	 * Method for making a deposit in a account
	 */
	@PostMapping(value = "/deposit")
	public ResponseEntity<?> makeDeposit(@RequestHeader("Authorization") String token,
			@Valid @RequestBody AccountInput accountInput) {
		transactionService.makeDeposit(token, accountInput);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/*
	 * Fallback method for deposit
	 */
	public ResponseEntity<?> accountFallbackForDeposit() {
		log.error("Rules Microservice is DOWN!");
		return new ResponseEntity<>(false, HttpStatus.GATEWAY_TIMEOUT);
	}

}
