package com.cts.AuditSeverity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * POD6 -Audit Management System
 * This is Application class for Spring boot
 *
 */

@SpringBootApplication

@EnableJpaRepositories(basePackages= {"com.cts.AuditSeverity.repository"})
@EntityScan(basePackages={"com.cts.AuditSeverity.model"})

@EnableFeignClients(basePackages = {"com.cts.AuditSeverity.fiegnclient"})

public class AuditSeverityApplication {
	/**
	 * main Method- SpringBoot main method to launch an application. 
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityApplication.class, args);
	}

}

