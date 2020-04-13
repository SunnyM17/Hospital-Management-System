import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DatabaseTestClass {
	
	//For this specific test, make a new folder at an alternative location
	//of your PC's file system in order to see how database functions work
	//after having changed the database file location
	
	//This test will be kind of a *** test and JUnit
	
	
	//have to specify on how to use this test
	@Test
	public void reload_test() {
		Database.reload();
		//Go to your old database with some presumably created previous users 
		//and please note one ID (or file name) in the old database and write it down
		
		String oldLocationName = new String ("C:\\Users\\jamen\\OneDrive\\Documents\\GitHub\\UHMSV5\\Hospital-Management-System\\database");
		File databsefile = new File (oldLocationName);		
		
		Integer fileName = 1773950;
		FileSystem fS = new FileSystem(fileName.toString());
		File fileInNewLocation = fS.getFile();
		boolean checked = false;
		
		for (File file : databsefile.listFiles()) {
			
			if(fileInNewLocation.getName().equals(file.getName())) {
				assertTrue("File that was in the directory is now in the new one", true);
				checked = true;
			}
		}
		
		if (checked == true) {}
		else { fail("File was not found, not written, reload did not work");}
		}
	
	@Test
	public void load_test() {
		Users user = new Users();
		Integer userID = 4362541;
		user.setFirstName("Jose");
		user.setLastName("Menjivar");
		user.setUserID(userID);
		user.setAddress("N.H road NW");
		user.setEmail("j.menjivar@yahoo.ca");
		try {
			user.setPassword("quarantineIsAwful2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setPhoneNum("1234566");
		FileSystem fS = new FileSystem(userID.toString());
		
		fS.writeGeneralInfoFile(fS.getFile(), user);
		Database.load(fS.getFile());
		
		if(Database.getUser(userID)== null) {
			fail("Nothing was loaded onto the required hasmaps");
		}
	}
	
	
	
	
}
