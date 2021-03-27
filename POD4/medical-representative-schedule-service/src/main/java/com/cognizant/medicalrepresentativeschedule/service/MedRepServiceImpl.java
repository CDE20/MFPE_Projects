package com.cognizant.medicalrepresentativeschedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicalrepresentativeschedule.dao.MedRepRepository;
import com.cognizant.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.cognizant.medicalrepresentativeschedule.feignclient.AuthenticationFeignClient;
import com.cognizant.medicalrepresentativeschedule.model.JwtResponse;
import com.cognizant.medicalrepresentativeschedule.model.MedicalRepresentative;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedRepServiceImpl implements MedRepService {

	@Autowired
	AuthenticationFeignClient authFeignClient;

	@Autowired
	private MedRepRepository medicalRepresentativesRepository;

	@Override
	public List<MedicalRepresentative> getMedicalRepresentatives(String token) throws TokenValidationFailedException {

		log.info("Start");

		log.debug("token : {}", token);

		if (!isValidSession(token)) {
			log.info("End");

			return null;
		}

		log.info("End");
		return medicalRepresentativesRepository.findAll();
	}

	public Boolean isValidSession(String token) throws TokenValidationFailedException {

		log.info("Start");

		JwtResponse response = authFeignClient.verifyToken(token);

		log.debug("response : {}", response);

		if (!response.isValid()) {
			log.info("End");

			throw new TokenValidationFailedException("Invalid Token");
		}

		log.info("End");

		return true;
	}

}
