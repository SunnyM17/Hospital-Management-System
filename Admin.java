import java.util.Arrays;
import java.util.Map;

/**
 * Represents the Administrator. 
 *
 */
public class Admin extends Users
{
    private int adminID = 300;

    public Admin()
    {
    	
    }

    /**
     * Gets a list of all the users from the database and arranges
     * their id and name into a string and stores them into an array.
     * The array is sorted in ascending order based on the ID of a user.
     * 
     * @return	String[]	This contains the ID and full name of all the users
     */
	public String[] getListOfUsers() {
		
		Map<Integer, Users> users = Database.getAllUsers();
		
		String[] userBasicInfo = new String[users.size()];
		int j =0;
		
		for(Integer i : users.keySet()) {
			userBasicInfo[j] = i + "       " + users.get(i).getFirstName() + " " + users.get(i).getLastName();
			j++;
		}
		// sorts the array in ascending order
		Arrays.sort(userBasicInfo);
		
		return userBasicInfo;
	}
	
	/**
	 * Deletes a user from the system by deleting the file associated 
	 * with the user and reloads the database to reflect the change.
	 * 
	 * @param id	The ID assigned to a user.
	 */
	public void deleteUser(int id) {
		
		if(id != super.getUserID()) {
			FileSystem.deleteFile(id);
			Database.reload();
		}
	}
	
	/**
	 * Adds a new department with the specified name to the hospital.
	 * 
	 * @param	name	Name of the department.
	 * @return	boolean	Indicates if a department is successfully added or not
	 */
	public boolean addDepartment(String name) {
		return Hospital.addNewDepartment(name);
	}
	
	/**
	 * It gets how much patients use each department.
	 * 
	 * @return	the total number of patients in each department
	 */
	public Object[][] getTrafficForDepartments(){
		
		Object[][] data = new Object[Hospital.getArrDepartments().length][Hospital.getArrDepartments().length];
		String[] departments = Hospital.getArrDepartments();
		
		for(int i = 0; i< departments.length; i++) {
			data[i][0] = departments[i];
		}
		
		for(int i = 0; i< departments.length; i++) {
			data[i][1] = 2;
		}
		
		return data;	
	}
	
}