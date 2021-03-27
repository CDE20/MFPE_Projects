package com.cognizant.medicalrepresentative.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.medicalrepresentativeschedule.model.JwtResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@Slf4j
public class JwtResponseTest {

	@Mock
	JwtResponse jwtResponse;

	@Before
	public void setUp() throws Exception {
		log.info("Start");
		jwtResponse = new JwtResponse("admin", "adminpass", true);
		log.info("End");
	}

	@Test
	public void testAuthResponseDetails() throws Exception {
		log.info("Start");
		assertEquals("admin", jwtResponse.getId());
		assertEquals("adminpass", jwtResponse.getName());
		assertEquals(true, jwtResponse.isValid());
		log.info("End");
	}

	@Test
	public void testToStringMethod() {
		log.info("Start");
		System.out.println(jwtResponse.toString());
		assertEquals("JwtResponse(id=" + jwtResponse.getId() + ", name=" + jwtResponse.getName() + ", valid=" + jwtResponse.isValid() + ")", jwtResponse.toString());
		log.info("End");
	}

	@Test
	public void testNoArgsConstructor() {
		log.info("Start");
		JwtResponse authResponse = new JwtResponse();
		assertEquals(authResponse, authResponse);
		log.info("End");
	}

	@Test
	public void testSetters() {
		jwtResponse.setName("Rock");
		jwtResponse.setId("admin");
		jwtResponse.setValid(true);
		assertEquals("Rock", jwtResponse.getName());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = jwtResponse.equals(jwtResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = jwtResponse.hashCode();
		assertEquals(hashCode, jwtResponse.hashCode());
	}

}
