package com.cognizant.medicinestock.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.medicinestock.exception.TokenValidationFailedException;
import com.cognizant.medicinestock.feignclient.AuthenticationFeignClient;
import com.cognizant.medicinestock.model.JwtResponse;
import com.cognizant.medicinestock.model.MedicineStock;
import com.cognizant.medicinestock.service.MedicineStockServiceImpl;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MedicineStockController {


	@Autowired
	private AuthenticationFeignClient authFeignClient;

	@Autowired
	private MedicineStockServiceImpl medicineStockService;

	@GetMapping("/medicine-stock-information")
	public ResponseEntity<?> getMedicineStockInformation(@RequestHeader(name = "Authorization") String token) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		List<MedicineStock> medicineStockInformation = null;
		try {
			JwtResponse jwtResponse = authFeignClient.verifyToken(token);
			log.debug("JwtResponse {}:", jwtResponse);
			if (jwtResponse.isValid()) {
				log.info("TOKEN IS VALID");
				medicineStockInformation = medicineStockService.getMedicineStockInformation();
			}
		} catch (FeignException e) {
			log.error("TOKEN VALIDATION FAILED");
			throw new TokenValidationFailedException("TOKEN EXPIRED");
		}
		log.info("END");
		return new ResponseEntity<>(medicineStockInformation, HttpStatus.OK);

	}

	@PostMapping("/byTreatingAilment/{treatingAilment}")
	public ResponseEntity<?> getMedicineByTreatingAilment(@RequestHeader(name = "Authorization") String token,
			@PathVariable("treatingAilment") String treatingAilment) {
		log.info("START");
		log.debug("TOKEN {}:", token);
		log.debug("TREATING AILMENT {}:", treatingAilment);
		List<String> medicines = new ArrayList<>();
		try {
			JwtResponse jwtResponse = authFeignClient.verifyToken(token);
			log.debug("JWT RESPONSE {}:", jwtResponse);
			if (jwtResponse.isValid()) {
				log.info("TOKEN IS VALID");
				List<MedicineStock> medicineByTargetAilment = medicineStockService
						.getMedicineByTargetAilment(treatingAilment);
				log.debug("MEDICINE BY TARGET AILMENT {}: ", medicineByTargetAilment);
				for (@SuppressWarnings("rawtypes")
				Iterator iterator = medicineByTargetAilment.iterator(); iterator.hasNext();) {
					MedicineStock medicineStock = (MedicineStock) iterator.next();
					medicines.add(medicineStock.getName());
				}
			}
		} catch (FeignException e) {
			log.error("TOKEN VALIDATION FAILED");
			throw new TokenValidationFailedException("TOKEN EXPIRED");
		}
		log.info("END");
		return new ResponseEntity<>(medicines.toArray(new String[0]), HttpStatus.OK);

	}


	@PostMapping("/get-stock-count/{medicine}")
	public ResponseEntity<?> getStockCountForMedicine(@RequestHeader(name = "Authorization") String token,
			@PathVariable("medicine") String medicine) {
		log.info("START");

		MedicineStock medicineStock = null;
		try {
			JwtResponse jwtResponse = authFeignClient.verifyToken(token);
			if (jwtResponse.isValid()) {
				medicineStock = medicineStockService.getNumberOfTabletsInStockByName(medicine);
			}
		} catch (FeignException e) {
			log.info("EXCEPTION: TOKEN EXPIRED");
			throw new TokenValidationFailedException("TOKEN EXPIRED");
		}
		log.info("END");
		return new ResponseEntity<>(medicineStock, HttpStatus.OK);
	}

	
	@PostMapping("/update-stock/{medicine}/{count}")
	public Boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,
			@PathVariable("medicine") String medicine, @PathVariable("count") int count) {

		log.info("START");
		Boolean ans = false;

		try {
			JwtResponse jwtResponse = authFeignClient.verifyToken(token);
			if (jwtResponse.isValid()) {
				ans = medicineStockService.updateNumberOfTabletsInStockByName(medicine, count);
			}
		} catch (FeignException e) {
			log.info("EXCEPTION : TOKEN EXPIRED");
			throw new TokenValidationFailedException("TOKEN EXPIRED");
		}
		log.info("END");
		return ans;

	}
}
