package com.returnordermanag.webPortal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.returnordermanag.webPortal.model")
@EnableJpaRepositories("com.returnordermanag.webPortal.dao")
@SpringBootApplication
@EnableFeignClients
public class ReturnOrderPortalApplication{
	
	static Logger logger = LoggerFactory.getLogger(ReturnOrderPortalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReturnOrderPortalApplication.class, args);
		 logger.info("Web portal started");
	}

}
