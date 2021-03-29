package com.authorizationMicroservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.authorizationMicroservice.model.User;
import com.authorizationMicroservice.repository.LoginRepository;
import com.authorizationMicroservice.service.CustomUserDetailsService;

public class UserDetailsTest {

	@Mock
	LoginRepository repository;

	@InjectMocks
	CustomUserDetailsService customUserDetailsService;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNotNullCustomUserDetailsService() {
		assertNotNull(customUserDetailsService);
	}

	@Test
	public void testNotNullLoginRepository() {
		assertNotNull(repository);
	}

	@Test
	public void testGetCorrectUsernameFromDatabase() {

		User user = new User(1, "admin@gmail.com", "password");

		when(repository.findByUsername("admin@gmail.com")).thenReturn(user);

		UserDetails userDetails = customUserDetailsService.loadUserByUsername("admin@gmail.com");

		assertEquals(user.getUsername(), userDetails.getUsername());

		assertEquals(user.getPassword(), userDetails.getPassword());

	}

	@Test
	public void testForInorrectUsernameFromDatabase() {

		User userInDB = new User(1, "admin@gmail.com", "12345");

		when(repository.findByUsername("admin@gmail.com")).thenReturn(userInDB);

		UserDetails userDetails = customUserDetailsService.loadUserByUsername("admin@gmail.com");

		User user = new User(1, "admin@gmail.com", "gfhhghhg");

		assertEquals(user.getUsername(), userDetails.getUsername());

		assertNotEquals(user.getPassword(), userDetails.getPassword());

	}

	@Test
	public void testForUsernameNotInDatabase() {
		exception.expect(UsernameNotFoundException.class);
		exception.expectMessage("User not found !!");
		UserDetails userDetails = customUserDetailsService.loadUserByUsername("asdfgh@gmail.com");
		assertNotNull(userDetails);
	}

}
