package com.cognizant.transactionservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cognizant.transactionservice.util.AccountInput;
import com.cognizant.transactionservice.util.TransactionInput;

class TransactionInputTest {

	TransactionInput input = new TransactionInput();
	AccountInput accIp = new AccountInput(1, 2000);

	@Test
	void setSourceAccountTest() {
		input.setSourceAccount(accIp);
		assertEquals(2000, input.getSourceAccount().getAmount());
	}

	@Test
	void setTargetAccountTest() {
		input.setTargetAccount(accIp);
		assertEquals(1, input.getTargetAccount().getAccountId());
	}

	@Test
	void setAmountTest() {
		input.setAmount(1000);
		assertEquals(1000, input.getAmount());
	}

	@Test
	void setReferenceTest() {
		input.setReference("Withdraw");
		assertEquals("Withdraw", input.getReference());
	}

}
