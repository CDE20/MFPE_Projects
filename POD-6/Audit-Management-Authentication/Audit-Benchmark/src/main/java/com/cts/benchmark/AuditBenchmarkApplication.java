package com.cts.benchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 
 * POD 6 -Audit Management System
 * This is Application class for Spring boot
 *
 */
@SpringBootApplication
@EnableFeignClients
public class AuditBenchmarkApplication {
	/**
	 * main Method- Spring Boot's method to launch an application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuditBenchmarkApplication.class, args);
	}

}
