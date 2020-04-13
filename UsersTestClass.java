import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class UsersTestClass {
	
	// Testing Constructors: 
	
	@Test
	public void constTest1() {
		Users user = new Users();
		assertEquals("Must not have any parameters made", null, user.getUsername());
		assertEquals("Must not have any parameters made", 0, user.getUserID());
		assertEquals("Must not have any parameters made", null, user.getPassword());
		
	}
	
	@Test
	public void constTest2() {
		Users user = new Users (343536, "Jason", "Bourne", "Ultimatum" );
		assertEquals("Checking if username is properly made", "Jason.Bourne", user.getUsername());
		assertEquals("Checking if the password was correctly recorded", "Ultimatum", user.getPassword() );
		assertEquals("Checking if the ID was properly made", 343536, user.getUserID() );
		
	}
	
	@Test
	public void constTest3() {
		Users user = new Users("Wayne", "Gretzky", 302274, "NYRangers", "wayne.gretzky@hockey.com", "145 Manhattan Block, NY", "4539264752");
		assertEquals("Address is expected to be:", "145 Manhattan Block, NY", user.getAddress());
		assertFalse("Make sure this is the wrong email:", user.getAddress() == "124 Manhattan Block, NY");
	
	}
	
	
	//Testing some setters (getters have been most tested above throught constructor tests)
	
	@Test
	public void test_all_setters() {
		Users user = new Users();
		user.setFirstName("Barack");
		user.setLastName("Obama");
		user.setUsername(user.getFirstName(), user.getLastName());
		try {
			user.setPassword("ForeverPotus");
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setEmail("barack.obama@gmail.com");
		assertEquals("First name should be:", "Barack", user.getFirstName());
		assertEquals("Last name should be:", "Obama", user.getLastName());
		assertEquals("Username should be:", "Barack.Obama", user.getUsername());
		assertTrue("The password is accepted", user.getPassword() == "ForeverPotus");
		;
	}
	
	//Testing Verification Methods widely used across the program
	
	@Test
	public void testingVerifyName_CorrectName() {
		assertTrue("This should be correct", Users.verifyName("Barack","Obama"));
		
	}
	
	@Test
	public void testingVerifyName_IncorrectName() {
		assertFalse("This should not be correct", Users.verifyName("Jason", ""));
	}
	
	@Test
	public void testingVerifyPassword_Correctly() {
		assertTrue("This should be a correct password:", Users.verifyPassword("abcd12345","abcd12345"));
	}
	
	@Test
	public void testingVerifyPassword_tooShort() {
		assertFalse("This should be an incorrect password:", Users.verifyPassword("abcd1", "abcd1"));
	
	}
	
	@Test 
	public void testingVerifyPassword_NotMatching() {
		assertFalse("This should be an unsuccessful attempt:", Users.verifyPassword("jason", "bourne"));
	}
	

	
}
