package com.rulesservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class RulesInputTest {	
  RulesInput accInp=new RulesInput();
	
	@Test
	void setAccountIdTest() {
		accInp.setAccountId(1);
		assertEquals(1, accInp.getAccountId());
	}
	
	@Test
	void setAmountTest() {
		accInp.setAmount(500);
		assertEquals(500,accInp.getAmount());
	}

}
