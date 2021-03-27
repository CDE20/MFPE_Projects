package com.cognizant.pharmacysupply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;




@SpringBootApplication
@EnableFeignClients
@Slf4j
public class PharmacySupplyApplication {
	public static void main(String[] args) {
		log.info("START");
		SpringApplication.run(PharmacySupplyApplication.class, args);
		log.info("END");
	}

}
