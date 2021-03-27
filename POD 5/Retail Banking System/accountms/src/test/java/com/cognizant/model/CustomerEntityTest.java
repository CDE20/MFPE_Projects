package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.cognizant.accountservice.model.CustomerEntity;

class CustomerEntityTest {


	CustomerEntity entity = new CustomerEntity();
	@SuppressWarnings("deprecation")
	CustomerEntity entity2 = new CustomerEntity("Cust101", "Pratik B", "Cust", new Date(1998, 9, 23), "EPIPB15A56",
			"Hadapsar Pune");

	@Test
	void setUserIdTest() {
		entity.setUserid("Cust101");
		assertEquals("Cust101", entity.getUserid());
	}

	@Test
	void setUserNameTest() {
		entity.setUsername("Cust101");
		assertEquals("Cust101", entity.getUsername());
	}

	@Test
	void setPasswordTest() {
		entity.setPassword("Cust101");
		assertEquals("Cust101", entity.getPassword());
	}

	@Test
	void setPanTest() {
		entity.setPan("EPIPB15A56");
		assertEquals("EPIPB15A56", entity.getPan());
	}

	@Test
	void setAddressTest() {
		entity.setAddress("Hadapsar Pune");
		assertEquals("Hadapsar Pune", entity.getAddress());
	}

	@SuppressWarnings("deprecation")
	@Test
	void setDateTest() {
		entity.setDateOfBirth(new Date(1998, 9, 23));
		assertEquals(new Date(1998, 9, 23), entity.getDateOfBirth());
	}

}
