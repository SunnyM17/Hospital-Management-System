import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
/**
 * Represents hospital's information
 */
public class Hospital {

	private static ArrayList<String> departments = new ArrayList() {{
		add("cardiology");
		add("neurology");
		add("urology");
		
	}};
	
	/**
	 * Adds a new department with the specified name.
	 * 
	 * @param	name	The name of the department.
	 * @return	boolean	The status of whether or not the department was successfully added.
	 */
	public static boolean addNewDepartment(String name) {
		
		// checks to see if the department already exists 
		if(!departments.contains(name.toLowerCase())){
			departments.add(name);
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Gets an array of all the departments.
	 * 
	 * @return String[]	An array of departments.
	 */
	public static String[] getArrDepartments(){
		
		String [] departmentArr = new String[departments.size()];
		int j = 0;
		
		// Adds elements in an arrayList to an array
		for(String i: departments) {
			departmentArr[j] = i;
			j++;
		}
		
		return departmentArr;
	}
	
	
	public static String[] getListOfUsers(Map<Integer, Users> users) {
		
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
	
	
}
