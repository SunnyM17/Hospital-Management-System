import java.util.HashMap;

public class Authorize {
	
	private HashMap<Integer, Users> accounts = new HashMap<Integer, Users>() ;
	public Authorize() {
		
	}
	
	public int register(String firstName, String lastName , String password, int type) {
		boolean checkFirstName = Users.verifyName(firstName);
		boolean checkLastName = Users.verifyName(lastName);
		boolean checkPassword = Users.verifyPassword(password);
		
		if(checkFirstName && checkLastName && checkPassword) {
			if(type != -1) {
				int id = generateID(type);
				accounts.put(id, new Users(firstName, lastName, password));
				System.out.println(id);
				return id;
			}
		}
		return -1;
	}
			
	 int generateID(int type) {
				
		int userID;
		do {
			if(type == 0)
					userID = (int) (Math.random() * (2000000 - 1000001) + 1000000);
				
			else if(type == 1) 
					userID = (int) (Math.random() * (3000000 - 2000001) + 2000000);
					
			else if(type == 2) 
					userID = (int) (Math.random() * (4000000 - 3000001) + 3000000);
					
			else if(type == 3) 
					userID = (int) (Math.random() * (5000000 - 4000001) + 4000000);
				
			else
					userID = -1;	
		} while(accounts.containsKey(userID)); 
			 					
				return userID;
	}
	 
	public boolean login(int id, String pass) {
			if(accounts.containsKey(id)) {
				Users temp = accounts.get(id);
				if(temp.getPassword().equals(pass)) {
					return true;
				}
			}
			
			return false;
	}		
}

