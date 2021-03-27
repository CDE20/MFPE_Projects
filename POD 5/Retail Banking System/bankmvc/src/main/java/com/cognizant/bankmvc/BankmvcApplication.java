package com.cognizant.bankmvc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class BankmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankmvcApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant.bankmvc")).build().apiInfo(apiInfo());

	}  

	private ApiInfo apiInfo() {
		return new ApiInfo("Bank MVC Portal", "MFPE project service", "API", "Terms of service",
				new Contact("Snehal", "", "Snehal@gmail.com"), "License of API", "",Collections.emptyList());
	}
 

}
