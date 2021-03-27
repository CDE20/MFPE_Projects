package com.cts.benchmark;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.benchmark.feignclient.AuthClient;
import com.cts.benchmark.service.TokenService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for returning benchmark of acceptable no of NO's for a particular
 * audit type to  Audit Severity microservice. 

 * @see AuthClient is used to verify the token.
 * @see tokenService is to check token with auth microservice
 * @see env is to acess values from properties file

 *
 */
@RestController
@Slf4j
public class BenchmarkController {
	@Autowired
	AuthClient authClient;
		
	@Autowired
	TokenService tokenService;
	
	@Autowired
	Environment env;
	
	/**
	 * 
	 * @param token - used to verfiy the token with auth service
	 * @return response entity which is either List of questions or error caused in application
	 */
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<?> getBenchmarkMap(@RequestHeader("Authorization") String token){
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		ResponseEntity<?> responseEntity=null;
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		if(tokenService.checkTokenValidity(token)) {
			
			responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList,HttpStatus.OK);
		}else {
			log.error(env.getProperty("string.token.exp")); 
			log.info(env.getProperty("string.end"));

			responseEntity= new ResponseEntity<String>(env.getProperty("string.token.exp"),HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;

	}
}