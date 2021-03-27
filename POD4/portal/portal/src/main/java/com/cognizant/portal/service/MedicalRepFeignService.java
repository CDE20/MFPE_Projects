package com.cognizant.portal.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.portal.feign.RepresentativeFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicalRepFeignService {
	

	@Autowired
	private RepresentativeFeignClient repFeignClient;

	public ResponseEntity<?> getRepSchedule(String token, String scheduleStartDate) {
		log.debug("token {}:", token);
		ResponseEntity<?> response = repFeignClient.getRepSchedule(getTokenWithHeader(token), scheduleStartDate);
		log.debug("response {}", response);
		return response;
	}


	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		log.debug("headers{}:", headers);
		
		String first = headers.getFirst("Authorization");
		log.debug("first {}:", first);
		
		return first;
	}

}
