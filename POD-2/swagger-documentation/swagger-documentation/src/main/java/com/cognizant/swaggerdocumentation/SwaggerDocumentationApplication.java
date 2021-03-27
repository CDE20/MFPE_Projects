package com.cognizant.swaggerdocumentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class SwaggerDocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocumentationApplication.class, args);
	}

}
