package com.cognizant.model;

import static org.junit.Assert.*;

/**
 * @author POD5
 * @version 1.8
 * @apiNote To test ProjectManager class
 * 
 *
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {
	
	ProjectManager projectManager = new ProjectManager();
	
	/**
	 * to test the all param constructor of userRetail
	 */
	@Test
	public void testProjectManagerAllConstructor()
	{
		ProjectManager manager=new ProjectManager("ab", "ab", null);
		assertEquals( "ab" , manager.getUserId());
	}
	/**
	 * to test the getter setter of Uid
	 */
	@Test
	public void testUserid()
	{
		projectManager.setUserId("abc");
		assertEquals( "abc",  projectManager.getUserId());
	}
	/**
	 * to test the getter setter of UserPassword
	 */
	@Test
	public void testUserPassword()
	{
		projectManager.setPassword("abc");
		assertEquals( "abc" , projectManager.getPassword());
	}
	/**
	 * to test the getter setter of AuthToken
	 */
	@Test
	public void testAuthToken()
	{
		projectManager.setAuthToken("abc");
		assertEquals("abc", projectManager.getAuthToken());
	}
	/**
	 * to test the toString
	 */
	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string , projectManager.toString());
	}

}
