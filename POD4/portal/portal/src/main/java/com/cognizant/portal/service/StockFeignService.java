package com.cognizant.portal.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.portal.feign.MedicineStockFeignClient;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class StockFeignService {

	@Autowired
	private MedicineStockFeignClient stockFeignClient;


	public ResponseEntity<?> getMedicineStockInformation(String token) {
		log.info("Start");
		log.debug("token{}:", token);
		ResponseEntity<?> response = stockFeignClient.getMedicineStockInformation(getTokenWithHeader(token));
		return response;
	}

	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		log.debug("headers{}:", headers);
		return headers.getFirst("Authorization");
	}

}
