package com.cognizant.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Test
	void contextLoads() {
		String check="Cust101";
		assertEquals("Cust101",check );
	}

}
