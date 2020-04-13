import static org.junit.Assert.*;

public class AuthorizeTestClass {
	
	/*
	 * This test class will test Authorize class using various 
	 * edge cases.
	 * Testing will be automated and will be performed using JUnit.
	 */
	
	@Test
	public void constTest()
	{
		Authorize auth = new Authorize();
		assertEquals("Must not have any parameters made", -1, auth.generateID(5));
		
	}
	
	@Test
	public void generateIDTest()
	{
		
		Authorize auth = new Authorize();
		int adminID = auth.generateID(0);
		int testAdmin = adminID - (1000000 - admin(ID));
		assertEquals("ID should be of administrator class", 1000000,testAdmin);
		
		int docID = auth.generateID(1);
		int testDoc = docID - (2000000 - docID);
		assertEquals("ID should be of doctor class", 2000000, testDoc);
		
		int patID = auth.generateID(2);
		int testPatient = patID - (3000000 - patID);
		assertEquals("ID should be of patient class", 3000000, testPatient);
		
		int assistantID = auth.generateID(3);
		int testAssistant = assistantID - (4000000 - assistantID);
		assertEquals("ID should be of assistant class", 4000000, testAssistant);
		
		int nurseID = auth.generateID(4);
		int testNurse = nurseID - (5000000 - nurseID);
		assertEquals("ID should be of nurse class", 5000000, testNurse);
		
	}
	
	@Test
	public void loginTest()
	{
		Authorize auth = new Authorize();
		assertEquals("No user should exist", false, auth.login(0,"hello"));
		
	}

}
