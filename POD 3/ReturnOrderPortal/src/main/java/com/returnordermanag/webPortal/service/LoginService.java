package com.returnordermanag.webPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanag.webPortal.dao.UserAuthenticationRepository;
import com.returnordermanag.webPortal.model.UserDetails;

@Service
public class LoginService {
	@Autowired
	private UserDetails userDetails;
	
	@Autowired
	private UserAuthenticationRepository userAuthenticationRepo;
	
	public void createUser(int userID, String userName, String password, String jwtToken, boolean isValid) {
		userDetails = new UserDetails(userID, userName, password, jwtToken, isValid);
		userAuthenticationRepo.save(userDetails);
	}
}
