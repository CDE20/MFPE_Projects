package com.cognizant.bankmvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionInput {

	private AccountInput sourceAccount;
	private AccountInput targetAccount;
	private double amount;
	private String reference;

	
}