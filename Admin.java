import java.util.Arrays;
import java.util.Map;

/**
 * Represents the Administrator. 
 */
public class Admin extends Users
{
    private int adminID = 300;

    public Admin()
    {
    	 super.setUserID(adminID);
         adminID += 1;
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