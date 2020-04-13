import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

// For this test class to function properly, you will need to update the location
// variable in the database class so test files can be pushed in and 
// out your file system. This is also true for the overall program to work

public class FileSystemTestClass {

	@Test
	public void constructorTest1_correctCreation() {
		FileSystem fileS = new FileSystem("TheFile");
		File myFile = fileS.getFile();
		if(myFile.exists()) {
			assertTrue("The file is created in the location", myFile.exists() == true);
		}
		else {
			fail("File doesn't exist, constructor is wrong");
		}
	}
	
	@Test
	public void constructorTest2_repeatedFile() {
		FileSystem fileS = new FileSystem("TheFile");
		File myFile2 = fileS.getFile();
		try {
			if(!myFile2.createNewFile()) {
				assertTrue("Correct Functioning",!myFile2.createNewFile());
			}
			else {
				fail("Creating repeated file, wrong");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Technically, the getter got tested up top but to be thorough
	
	@Test
	public void getterTest1() {
		FileSystem fileIO = new FileSystem("FileIO");
		if(fileIO.getFile().exists()) {
			
		}
		else {
			fail("file was created but not retreived");
		}
		
	}
	
	//CreateFile was technically tested in the constructor
	//we tested again to be thorough
	
	@Test
	public void createFileTest() {
		FileSystem system = new FileSystem("thatFile");
		//The constructor is a proxy for createFile method.
		if(system.getFile().exists()) {}
		else {
			fail("did not create desired file");
		}
	}
	
	@Test
	public void writeGeneralInfoToFile_T1() {
		Users user = new Users();
		user.setFirstName("Jonah(JJ)");
		user.setLastName("Byrde(JJ)");
		try {
			user.setPassword("moneyLaunder(JJ)");
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setEmail("jonah.byrde@ozark.com(JJ)");
		user.setAddress("145 Dash St. NW, Ozark(JJ)");
		user.setPhoneNum("123456789(JJ)");
		
		FileSystem fSys = new FileSystem("classFile(JJ)");
		File classFile = fSys.getFile();
		
		fSys.writeGeneralInfoFile(classFile, user);
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(classFile));
			String line = bf.readLine();
			while(line != null) {
				if(line.contains("JJ")) {
					assertTrue("Line was typed properly", line.contains("JJ"));
				}
				else {
					fail("Not typed into file");
				}
				line = bf.readLine();
			}
			bf.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeToFile_Test() {
		FileSystem theSystem = new FileSystem("testSys");
		File file_T = theSystem.getFile();
		
		theSystem.writeToFile(file_T,"This is a test file");
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file_T));
			String line = bf.readLine();
			while(line == null) {
				line= bf.readLine();
			}
			while(line != null) {
				if(line.contains("This is a test file")) {
					assertTrue("Line was typed properly", line.contains("This is a test file"));
				}
				else {
					fail("Not typed into file");
				}
				line = bf.readLine();
			}
			bf.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteFile_test() {
		FileSystem system1 = new FileSystem("5041004");
		File testFile2= system1.getFile();
		//Since we have tested the existence of the file previously
		//we assume that the file is in fact in the located file system
		
		FileSystem.deleteFile(5041004);
		if(testFile2.exists()) {
			fail("failed to delete created file");

		}
		
	}
	
}
