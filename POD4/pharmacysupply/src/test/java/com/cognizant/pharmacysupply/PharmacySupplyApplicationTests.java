package com.cognizant.pharmacysupply;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PharmacySupplyApplicationTests {

	@Mock
	PharmacySupplyApplication PharmacySupplyApplication;
	@Test
	void contextLoads() {
		assertNotNull(PharmacySupplyApplication);
	}
	 @SuppressWarnings("static-access")
	@Test
	   public void main() {
	      PharmacySupplyApplication.main(new String[] {});
	   }

}
