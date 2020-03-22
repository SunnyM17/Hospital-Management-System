import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSystem {

	private File file;
	
	public FileSystem(String name) {
		createFile(name);
	}
	
	public File getFile() {
		return this.file;
	}
	
	public void createFile(String name){ 
		/* Creates a new file in the directory named "Files"
		 */
		
		try {
			File newFile = new File("C:\\Hospital-Management-System-master\\Files\\" + name + ".txt");
			this.file = newFile;
			if(!newFile.createNewFile()) {
				System.out.println("File already exists");
			}
			
		} catch(Exception e) {
			System.out.println("Error");
		}
	}
		
	
	public void writeGeneralInfoFile(File file, Users user) {
		/* Writes general information about the user to the file 
		  */
		try {
		FileWriter fw = new FileWriter(file); 
		PrintWriter pw = new PrintWriter(fw);
		pw.println(user.getFirstName());
		pw.println(user.getLastName());
		pw.println(user.getPassword());
		pw.println(user.getEmail());
		pw.println(user.getAddress());
		pw.print(user.getPhoneNum());
		pw.close();
		} catch(IOException e) {
			System.out.println("There was an error");

		}	
	}
	
	public void writeToFile(File file, String info) {
		/* Writes a string to the file 
		  */
		try {
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println();
			pw.println(info);
			pw.close();
		} catch(IOException e) {
			System.out.println("There was an error");
		}
	}
}
