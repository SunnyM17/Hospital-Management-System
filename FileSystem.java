import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents all the functionalities related to manage a 
 * file for a user.
 */
public class FileSystem {

	private File file;
	
	/**
	 * Class constructor specifying the name of the file.
	 * 
	 * @param name	Name of the file
	 */
	public FileSystem(String name) {
		// creates a new file
		createFile(name);
	}
	
	/**
	 * Gets the file.
	 * 
	 * @return File	Returns the file.
	 */
	public File getFile() {
		return this.file;
	}
	
	/**
	 * Creates a new text file.
	 * 
	 * @param name	name of the file (without the .txt extension).
	 */
	public void createFile(String name){ 
		
		try {
			/* To write to text file: Change LOCATION string in Database class
			* to the local folders that you keep the database directory in.
			* */
			File newFile = new File(Database.LOCATION + "\\" + name + ".txt");
			this.file = newFile;
			if(!newFile.createNewFile()) {
				System.out.println("File already exists");
			}
			
		} catch(Exception e) {
			System.out.println("Error: "+e.toString());
		}
	}
		
	/**
	 * Writes general information (first name, last name, password,...,phoneNum) 
	 * about the user to the specified file.
	 * 
	 * @param file	File where the information needs to be stored.
	 * @param user	The user whose information needs to be written to a file.
	 */
	public void writeGeneralInfoFile(File file, Users user) {
		
		try {
		FileWriter fw = new FileWriter(file); 
		PrintWriter pw = new PrintWriter(fw);
		pw.println(user.getFirstName());
		pw.println(user.getLastName());
		pw.println(user.getPassword());
		pw.println(user.getEmail());
		pw.println(user.getAddress());
		pw.print(user.getPhoneNum());
		pw.println();
		pw.close();
		fw.close();
		} catch(IOException e) {
			System.out.println("There was an error");

		}
	}
	
	/**
	 * Writes a string to the end of a specified file.
	 * 
	 * @param file	File where the information needs to be stored.
	 * @param info	String that needs to be written.
	 */
	public void writeToFile(File file, String info) {
		try {
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(info);
			pw.close();
			fw.close();
		} catch(IOException e) {
			System.out.println("There was an error");
		}
	}
	
	/**
	 * Deletes an existing text file.
	 * 
	 * @param id	The ID of a user whose file needs to be deleted.
	 */
	public static void deleteFile(int id) {
		
		try {
			/* To write to text file: Change LOCATION string in Database class
			* to the local folders that you keep the database directory in
			* */
			File file = new File(Database.LOCATION + "\\" + id + ".txt");
				
			if(file.delete()) {
				System.out.println("Deleted" + file.getName());
			} else {
				System.out.println("Not Deleted");
			}
			
		} catch(Exception e) {
			System.out.println("Error: "+e.toString());
		}
		    	
	}
}
