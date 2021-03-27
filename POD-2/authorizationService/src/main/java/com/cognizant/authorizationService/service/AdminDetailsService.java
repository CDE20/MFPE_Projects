package com.cognizant.authorizationService.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authorizationService.model.UserData;
import com.cognizant.authorizationService.repository.UserRepository;


@Service
public class AdminDetailsService implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(AdminDetailsService.class);

	@Autowired
	private UserRepository userRepository;
/**
 * Get UserData using JpaRepository, to get data by username,
 * throw exceptions if user not found
 */
	@Override
	public UserDetails loadUserByUsername(String uid) {
		logger.info("START");
		try {
			UserData custuser = userRepository.findById(uid).orElse(null);
			if (custuser != null) {
				custuser.getUname();
				logger.info("END - User found");
				return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
			} else {
				logger.info("END - UsernameNotFound");
				throw new UsernameNotFoundException("UsernameNotFoundException");
			}
		} catch (Exception e) {
			logger.info("EXCEPTION - UsernameNotFoundException");
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}

	}

}
