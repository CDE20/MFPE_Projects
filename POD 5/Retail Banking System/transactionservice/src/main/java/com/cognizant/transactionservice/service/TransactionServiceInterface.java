package com.cognizant.transactionservice.service;

import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;

public interface TransactionServiceInterface {

	public boolean makeTransfer(String token, TransactionInput transactionInput);

	public boolean makeWithdraw(String token, AccountInput accountInput);

	public boolean makeDeposit(String token, AccountInput accountInput);
	
	public boolean makeServiceCharges(String token, AccountInput accountInput);
}
