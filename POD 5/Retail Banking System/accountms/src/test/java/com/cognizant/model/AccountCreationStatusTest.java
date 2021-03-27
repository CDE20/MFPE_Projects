package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.accountservice.model.AccountCreationStatus;

class AccountCreationStatusTest {

	AccountCreationStatus status = new AccountCreationStatus();

	@Test
	void setAccountIdTest() {
		status.setAccountId(1);
		assertEquals(1, status.getAccountId());
	}

	@Test
	void setMessageTest() {
		status.setMessage("Sucessfully Created");
		;
		assertEquals("Sucessfully Created", status.getMessage());
	}
}
