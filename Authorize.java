import java.util.HashMap;

/**
* Allows the user to register and login
* 
* Reference: https://github.com/colinauyeung/loginapp
*/

public class Authorize {

	public Authorize() {
		
	}
	
	/**
	 * Creates a new user and adds them into the system.
	 * 
	 * @param	firstName	First name of the user.
	 * @param	lastName	Last name of the user.
	 * @param	email		Email address of the user.
	 * @param	address		Address of the user.
	 * @param	num			Phone number of the user
	 * @param	password	Password of the user.
	 * @param	pass2		Confirmation Password that the user enters.
	 * @param 	role		The role/position of the user in the hospital.
	 * @return	int			Returns either the id of the user (successful registration)
	 * 						or -1(unsuccessful registration)
	 */
	public int register(String firstName, String lastName , String email, String address, String num, String password, String pass2, int role) {
		 // checks if the name and password follows convention 
		 boolean checkName = Users.verifyName(firstName, lastName);
		 boolean checkPassword = Users.verifyPassword(password, pass2);
		
		if(checkName && checkPassword) {
			if(role != -1) {
				int id = generateID(role);
				Users newUser = new Users(firstName, lastName, id, password, email, address, num);
				newRecord(id, newUser);
				return id;
			}
		}
		return -1;
	}
	
	 /**
	  * Generates a random ID for the user based on their role(Patient, Assistant, Nurse...).
	  * 
	  * @param	role	the position/role of the user in the hospital
	  * @return	int		A 7- digit number(user ID).
	  */
	 int generateID(int role) {	
		int userID;
		
		do {
			// Administrator 
			if(role == 0)
				userID = (int) (Math.random() * (2000000 - 1000001) + 1000000);
			
			// Doctor
			else if(role == 1) 
				userID = (int) (Math.random() * (3000000 - 2000001) + 2000000);
			
			// Patient
			else if(role == 2) 
				userID = (int) (Math.random() * (4000000 - 3000001) + 3000000);
			
			// Assistant
			else if(role == 3) 
				userID = (int) (Math.random() * (5000000 - 4000001) + 4000000);
			
			// Invalid Role
			else
				userID = -1;	
		} while(Database.userExists(userID));
			 					
				return userID;
	}
	 
	/**
	 * Allows the user to login by verifying that the ID corresponds to the correct password.
	 *  
	 * @param	id		ID of the user wanting to login.
	 * @param	pass	Password of the user wanting to login.
	 * @return	boolean	Returns a boolean value indicating if the login was been successful or not	
	 * 					(True if successful else False).
	 */
	public boolean login(int id, String pass) {
			if(Database.userExists(id)) {
				Users temp = Database.getUser(id);
				if (temp != null) {
					return temp.getPassword().equals(pass);
				}
			}
			return false;
	}
	
	/**
	 * Creates a new file for the user with all the general information. 
	 * 
	 * @param id		ID of the user whose file needs to be created.
	 * @param newUser	A user whose file needs to be created. 
	 */
	public void newRecord(int id, Users newUser) {
		FileSystem newFile = new FileSystem(""+id);
		newFile.writeGeneralInfoFile(newFile.getFile(), newUser);
		// load into database
		Database.load(newFile.getFile());
	}
}

