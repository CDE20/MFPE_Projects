package com.cognizant.portal.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.portal.feign.PharmacySupplyFeignClient;
import com.cognizant.portal.model.MedicineDemand;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class SupplyFeignService {


	@Autowired
	private PharmacySupplyFeignClient supplyFeignClient;

	public ResponseEntity<?> getPharmacySupply(String token, List<MedicineDemand> medicineDemand) {
		log.info("Start");
		log.debug("token{}:", token);
		ModelAndView modelAndView = new ModelAndView();
		ResponseEntity<?> response = null;
		try {
			response = supplyFeignClient.getPharmacySupply(getTokenWithHeader(token), medicineDemand);
			log.debug("response{}:", response);
		} catch (FeignException e) {
			modelAndView.setViewName("medicineNotFound");
			return new ResponseEntity<>("medicineNotFound", HttpStatus.NOT_FOUND);
		}
		return response;
	}


	public ResponseEntity<?> getMedicineSupply(String token) {
		log.debug("token{}:", token);
		ResponseEntity<?> response = null;
		response = supplyFeignClient.getMedicineSupply(getTokenWithHeader(token));
		log.debug("response{}:", response);
		return response;
	}


	public ResponseEntity<?> getMedicineDemand(String token) {
		log.debug("token{}:", token);
		ResponseEntity<?> response = null;
		response = supplyFeignClient.getMedicineDemand(getTokenWithHeader(token));
		log.debug("response{}:", response);
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
