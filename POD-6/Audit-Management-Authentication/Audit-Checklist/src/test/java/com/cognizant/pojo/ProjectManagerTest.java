package com.cognizant.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 
 * 			This class contains test cases for the ProjectManager class
 *          which are written using junit and mockito
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {
	
	ProjectManager projectManager = new ProjectManager();
	
	/**
	 * test the allArgsConstructor of ProjectManager model class
	 */
	@Test
	public void testProjectManagerAllConstructor()
	{
		ProjectManager manager=new ProjectManager("ab", "ab", null);
		assertEquals( "ab" , manager.getUserId());
	}
	/**
	 * test the Getter and Setter of UserId ProjectManager model class
	 */
	@Test
	public void testUserid()
	{
		projectManager.setUserId("abc");
		assertEquals( "abc",  projectManager.getUserId());
	}
	/**
	 * test the Getter and Setter of Password in ProjectManager model class
	 */
	@Test
	public void testUserPassword()
	{
		projectManager.setPassword("abc");
		assertEquals( "abc" , projectManager.getPassword());
	}
	/**
	 * test the Getter and Setter of AuthToken in ProjectManager model class
	 */
	@Test
	public void testAuthToken()
	{
		projectManager.setAuthToken("abc");
		assertEquals("abc", projectManager.getAuthToken());
	}
	/**
	 * test the toString in ProjectManager model class
	 */
	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string , projectManager.toString());
	}

}
