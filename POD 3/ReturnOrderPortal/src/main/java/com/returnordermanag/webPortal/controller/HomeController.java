package com.returnordermanag.webPortal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.returnordermanag.webPortal.client.AuthenticationFeignClient;
import com.returnordermanag.webPortal.model.AuthenticationRequest;
import com.returnordermanag.webPortal.model.AuthenticationResponse;
import com.returnordermanag.webPortal.service.LoginService;

@Controller
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private AuthenticationRequest authenticationRequest;

	@Autowired
	private AuthenticationResponse authenticationResponse;

	@Autowired
	private AuthenticationFeignClient authenticationFeignClient;

	@RequestMapping("/")
	public String open() {

		return "login.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

		logger.info("Handling /login request");
		
		authenticationRequest.setUsername(username);
		authenticationRequest.setPassword(password);

		authenticationResponse = authenticationFeignClient.createAuthenticationToken(authenticationRequest);

		String jwtToken = authenticationResponse.getJwtToken();
		boolean isValid = authenticationResponse.getValid();
		int userID = 101; 

		loginService.createUser(userID, username, password, jwtToken, isValid);
		
		boolean valid = 	authenticationResponse.getValid();
		
		if (valid)
			return "home.jsp";

		return "login.jsp";

	}
	

}