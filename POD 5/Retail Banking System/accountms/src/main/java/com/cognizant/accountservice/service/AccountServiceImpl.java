package com.cognizant.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.accountservice.exceptionhandling.AccessDeniedException;
import com.cognizant.accountservice.exceptionhandling.AccountNotFoundException;
import com.cognizant.accountservice.feignclient.AuthFeignClient;
import com.cognizant.accountservice.feignclient.TransactionFeign;
import com.cognizant.accountservice.model.Account;
import com.cognizant.accountservice.model.AccountCreationStatus;
import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.AuthenticationResponse;
import com.cognizant.accountservice.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
	
	/**
	 *  Class used Implementing account service -> Service Layer class
	 */
	
	@Autowired
	private AuthFeignClient authFeignClient;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionFeign transactionFeign;


	/*
	 *  service method to create customer account
	 */
	@Override
	public AccountCreationStatus createAccount(String customerId, Account account) {
		accountRepository.save(account);
		AccountCreationStatus accountCreationStatus = new AccountCreationStatus(account.getAccountId(),"Sucessfully Created");
		log.info("Account Created Sucessfully");
		return accountCreationStatus;
	}


	/*
	 *   service method to get customer account
	 */
	@Override
	public List<Account> getCustomerAccount(String token, String customerId) {
		List<Account> accountList = accountRepository.findByCustomerId(customerId);
		for (Account acc : accountList) {
			acc.setTransactions(transactionFeign.getTransactionsByAccId(token, acc.getAccountId()));
		}
		return accountList;
	}

	
	/*
	 *  service method to get account by account id
	 */
	@Override
	public Account getAccount(long accountId) {
		Account account = accountRepository.findByAccountId(accountId);
		if (account == null) {
			throw new AccountNotFoundException("Account Does Not Exist");
		}
		return account;
	}

	
	/*
	 *  service method to update balance withdraw
	 */
	@Override
	public Account updateBalance(AccountInput accountInput) {
		log.info("toUpdateAcc--->" + accountInput.getAccountId());
		Account toUpdateAcc = accountRepository.findByAccountId(accountInput.getAccountId());
		toUpdateAcc.setCurrentBalance(toUpdateAcc.getCurrentBalance() - accountInput.getAmount());
		return accountRepository.save(toUpdateAcc);
	}

	
	/*
	 *  service method to update balance deposit
	 */
	@Override
	public Account updateDepositBalance(AccountInput accountInput) {
		log.info("toUpdateAcc--->" + accountInput.getAccountId());
		Account toUpdateAcc = accountRepository.findByAccountId(accountInput.getAccountId());
		toUpdateAcc.setCurrentBalance(toUpdateAcc.getCurrentBalance() + accountInput.getAmount());
		return accountRepository.save(toUpdateAcc);
	}

	
	/*
	 *  service method to check token validity
	 */
	@Override
	public AuthenticationResponse hasPermission(String token) {
		return authFeignClient.getValidity(token);
	}

 
	/*
	 *  service method to check validity and employee permissions
	 */
	@Override
	public AuthenticationResponse hasEmployeePermission(String token) {
		AuthenticationResponse validity = authFeignClient.getValidity(token);
		if (!authFeignClient.getRole(validity.getUserid()).equals("EMPLOYEE"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}

	 
	/*
	 *  service method to check validity and customer permissions
	 */
	@Override
	public AuthenticationResponse hasCustomerPermission(String token) {
		AuthenticationResponse validity = authFeignClient.getValidity(token);
		if (!authFeignClient.getRole(validity.getUserid()).equals("CUSTOMER"))
			throw new AccessDeniedException("NOT ALLOWED");
		else
			return validity;
	}
	
	@Override
	public List<Account> getAllAccounts(){
		// TODO Auto-generated method stub
		try {
			return accountRepository.findAll();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}