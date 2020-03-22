import java.util.HashMap;

/**
* Class: Authorize 
* Class Description: Allows the user to register and login
* Methods:
* 		register
* 		generateID
* 		login
*
* Reference: https://github.com/colinauyeung/loginapp
*/

public class Authorize {
	
	
	private HashMap<Integer, Users> accounts = new HashMap<Integer, Users>();
	public Authorize() {
		
	}
	
	public int register(String firstName, String lastName , String email, String address, String num, String password, String pass2, int role) {
		/* Creates a new User 
		 */
		 boolean checkName = Users.verifyName(firstName, lastName);
		 boolean checkPassword = Users.verifyPassword(password, pass2);
		
		if(checkName && checkPassword) {
			if(role != -1) {
				int id = generateID(role);
				Users newUser = new Users(firstName, lastName, id, password, email, address, num);
				accounts.put(id, newUser);
				System.out.println(id);
				newRecord(id, newUser);	
				return id;
			}
		}
		return -1;
	}
			
	 int generateID(int role) {
		 /* Generates a random ID for the user based on their role
		  */
				
		int userID;
		do {
			if(role == 0)
					userID = (int) (Math.random() * (2000000 - 1000001) + 1000000);
				
			else if(role == 1) 
					userID = (int) (Math.random() * (3000000 - 2000001) + 2000000);
					
			else if(role == 2) 
					userID = (int) (Math.random() * (4000000 - 3000001) + 3000000);
					
			else if(role == 3) 
					userID = (int) (Math.random() * (5000000 - 4000001) + 4000000);
				
			else
					userID = -1;	
		} while(accounts.containsKey(userID)); 
			 					
				return userID;
	}
	 
	public boolean login(int id, String pass) {
		/* Allows the user to login by verifying that the ID corresponds to the correct password
		 */
			if(accounts.containsKey(id)) {
				Users temp = accounts.get(id);
				if(temp.getPassword().equals(pass)) {
					return true;
				}
			}
			
			return false;
	}
	
	public void newRecord(int id, Users newUser) {
		/* Creates a new file for the user with all the general information 
		 */
		FileSystem newFile = new FileSystem(""+id);
		newFile.writeGeneralInfoFile(newFile.getFile(), newUser);
		// load into database
		Database.load(newFile.getFile());
	}
}

