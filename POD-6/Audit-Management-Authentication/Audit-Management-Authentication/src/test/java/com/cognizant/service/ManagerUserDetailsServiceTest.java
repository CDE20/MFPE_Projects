package com.cognizant.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.ProjectManager;
import com.cognizant.repository.ManagerRepository;

/**
  This class is used to load the user details from database and
 *          checking whether the user resides in database or not based on the
 *          given id. This class will implement the {@link ManagerUserDetailsService}
 *          interface. The interface requires only one read-only method, which
 *          simplifies support for newdata-access strategies.
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerUserDetailsServiceTest {

UserDetails userdetails;
	
	@InjectMocks
	ManagerDetailsService managerdetailservice;

	@Mock
	ManagerRepository userservice;
	/**
	 * This method is used to test  user details from database and checking
	 * whether the user resides in database or not based on the given id. If the
	 * user not present in the database it will throw an exception
	 * UsernameNotFoundException. And if user is present in the database it will
	 * simply return the {@link User} object
	 * 
	
	 */
	@Test
	public void loadUserByUsernameTest() {
		
		ProjectManager user1=new ProjectManager("admin","admin",null);
		Optional<ProjectManager> data =Optional.of(user1) ;
		when(userservice.findById("admin")).thenReturn(data);
		UserDetails loadUserByUsername2 = managerdetailservice.loadUserByUsername("admin");
		assertEquals(user1.getUserId(),loadUserByUsername2.getUsername());
	}

}
