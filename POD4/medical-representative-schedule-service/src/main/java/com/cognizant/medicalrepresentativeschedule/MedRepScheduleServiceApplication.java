package com.cognizant.medicalrepresentativeschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class MedRepScheduleServiceApplication {
	
	public static void main(String[] args) {
		log.info("Start");
		
		SpringApplication.run(MedRepScheduleServiceApplication.class, args);
		log.info("End");
	}

}
