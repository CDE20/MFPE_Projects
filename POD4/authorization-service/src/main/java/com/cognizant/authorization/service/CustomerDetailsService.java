package com.cognizant.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authorization.exception.UserNotFoundException;
import com.cognizant.authorization.model.MyUser;
import com.cognizant.authorization.repository.MyUserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to load the user details from the database and check
 * whether the user resides in database or not based on the given id. 
 * This class implements the UserDetailsService interface. 
 */
@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private MyUserRepository userdao;

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		log.debug("USERID ", uid);
		MyUser custuser = userdao.findById(uid).orElseThrow(() -> new UserNotFoundException(
				"YOU ARE NOT AN AUTHENTICATED USER. PLEASE TRY TO LOGIN WITH THE VALID CREDENTIALS"));
		log.debug("CUSTUSER {}:", custuser);
		return new User(custuser.getUserid(), custuser.getPassword(), new ArrayList<>());

	}

}
