package com.cognizant.bankmvc.model;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
	
	private long accountId;
	
	private String customerId;

	private double currentBalance;
	
	private String accountType;
	
	private String ownerName;

	private transient List<Transaction> transactions = new ArrayList<Transaction>();


}