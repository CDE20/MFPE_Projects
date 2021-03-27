package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

 // This is Application class for Spring boot
 
@SpringBootApplication
@EnableFeignClients
public class AuditWebPortalApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AuditWebPortalApplication.class, args);
	}

}
