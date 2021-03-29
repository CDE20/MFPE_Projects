package com.pensionerDetailsMicroservice;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PensionerDetailsMicroserviceApplication {

	public static void main(String[] args)
			throws IOException, NotFoundException, NumberFormatException, ParseException {
		SpringApplication.run(PensionerDetailsMicroserviceApplication.class, args);
	}

}