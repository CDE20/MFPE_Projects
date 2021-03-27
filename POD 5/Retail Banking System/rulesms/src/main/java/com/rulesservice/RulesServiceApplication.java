package com.rulesservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class RulesServiceApplication {
	//To run rules microservice
	public static void main(String[] args) {
		SpringApplication.run(RulesServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rulesservice.controller")).build().apiInfo(apiInfo());

	}  

	private ApiInfo apiInfo() {
		return new ApiInfo("Rules Service", "MFPE project service", "API", "Terms of service",
				new Contact("Aniruddh", "", "Aniruddh@gmail.com"), "License of API", "",Collections.emptyList());
	}
	
}
