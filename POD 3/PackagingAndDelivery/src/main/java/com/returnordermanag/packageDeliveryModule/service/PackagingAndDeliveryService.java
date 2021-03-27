package com.returnordermanag.packageDeliveryModule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PackagingAndDeliveryService {
	
	static Logger logger = LoggerFactory.getLogger(PackagingAndDeliveryService.class);

	static final int PROTECTIVESHEATH = 50;
	static final int INTEGRALPACKING = 100;
	static final int ACCESSORYPACKAGING = 50;
	static final int INTEGRALDELIVERY = 200;
	static final int ACCESSORYDELIVERY = 100;
	private int packagingAndDeliveryCost = 0;

	public int getPackingAndDeliveryCharge(String componentType, int count) {

		logger.info("Calculating packaging and delivery charges");
		
		if (componentType.equals("integral") || componentType.equals("Integral")) {
			packagingAndDeliveryCost = PROTECTIVESHEATH + INTEGRALPACKING + INTEGRALDELIVERY;
			return (packagingAndDeliveryCost * count);
		}

		else if (componentType.equals("accessory") || componentType.equals("Accessory")) {
			packagingAndDeliveryCost = PROTECTIVESHEATH + ACCESSORYPACKAGING + ACCESSORYDELIVERY;
			return (packagingAndDeliveryCost * count);
		}

		return packagingAndDeliveryCost;
	}
}
