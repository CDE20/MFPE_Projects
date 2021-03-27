package com.returnordermanag.packageDeliveryModule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanag.packageDeliveryModule.controller.PackagingAndDeliveryController;

@SpringBootTest
class PackagingAndDeliveryApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void PackageAndDeliveryTestForIntegral() {
		PackagingAndDeliveryController pdc = new PackagingAndDeliveryController();
		double actualResult = pdc.packagingAndDeliveryCost("integral", 10);
		double expectedResult = 3500.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForAccessory() {
		PackagingAndDeliveryController pdc = new PackagingAndDeliveryController();
		double actualResult = pdc.packagingAndDeliveryCost("accessory", 10);
		double expectedResult = 2000.0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void PackageAndDeliveryTestForCountIsZero() {
		PackagingAndDeliveryController pdc = new PackagingAndDeliveryController();
		double actualResult = pdc.packagingAndDeliveryCost("integral || accessory", 0);
		double expectedResult = 0;
		Assertions.assertEquals(expectedResult, actualResult);
	}

}