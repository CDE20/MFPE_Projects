package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.accountservice.model.AccountInput;
import com.cognizant.accountservice.model.TransactionInput;

class TransactionInputTest {

	TransactionInput input = new TransactionInput();
	AccountInput accIp = new AccountInput(1, 2000);
	TransactionInput input2 = new TransactionInput(accIp, accIp, 1000, "Deposit");

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
