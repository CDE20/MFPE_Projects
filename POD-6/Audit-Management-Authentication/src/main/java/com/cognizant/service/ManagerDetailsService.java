package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.model.ProjectManager;
import com.cognizant.repository.ManagerRepository;

import lombok.extern.slf4j.Slf4j;
/**
 This class is used to load the user details from database and
 *          checking whether the user resides in database or not based on the
 *          given id. This class will implement the {@link UserDetailsService}
 *          interface. The interface requires only one read-only method, which
 *          simplifies support for newdata-access strategies.
 *
 */
@Service
@Slf4j
public class ManagerDetailsService implements UserDetailsService {
	/**
	 * This field is used to communicate with the database. It has the annotation
	 * autowired which will automatically inject the bean.
	 * 
	
	 */
	@Autowired
	private ManagerRepository repository;
	
	/**
	 * This method is used to load the user details from database and checking
	 * whether the user resides in database or not based on the given id. If the
	 * user not present in the database it will throw an exception
	 * UsernameNotFoundException. And if user is present in the database it will
	 * simply return the {@link User} object
	 * 
	
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("Start : {}", "loadUserByUsername");

		ProjectManager manager = repository.findById(username).orElseThrow( 
				() -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));
		log.debug("End : {}", "loadUserByUsername");
		System.out.println(manager.toString());
		return new User(manager.getUserId(), manager.getPassword(), new ArrayList<>());

	}

	public void saveUser(ProjectManager projectManager) {
		// TODO Auto-generated method stub
		repository.save(projectManager);
		
	}

}
