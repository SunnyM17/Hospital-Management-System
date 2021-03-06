import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reads text files from database directory, scans document and creates a new instance
 * of object depending on what type of user it is
 * Maintains a map of all users
 * **/

public class Database {

    /**
     * Change LOCATION string based on where you store the project locally
     * depending on absolute path of where you keep the database
     * **/
	static final String LOCATION = "C:\\Users\\Simran\\eclipse-workspace\\HospitalManagement\\database";
    //static final String LOCATION = "C:\\Users\\carme\\Desktop\\SENG 300\\Group Project\\SENG 300 - Github Repo\\Hospital-Management-System\\database";
    /** Maps of all users **/
    private static final Map<Integer,Users> USERS = new HashMap<>();
    private static final Map<Integer,Admin> ADMINS = new HashMap<>();
    private static final Map<Integer,Doctor> DOCTORS = new HashMap<>();
    private static final Map<Integer,Assistant> ASSISTANTS = new HashMap<>();
    private static final Map<Integer,Patient> PATIENTS = new HashMap<>();
    private static final Map<Integer,Nurse> NURSES = new HashMap<>();


    /** Empty all maps when reloading **/
    private static void emptyAllMaps(){
        System.out.println("Clearing all database maps...");
        USERS.clear();
        ADMINS.clear();
        DOCTORS.clear();
        ASSISTANTS.clear();
        PATIENTS.clear();
        NURSES.clear();
    }

    /**
     * Loads all users - is called at start of program
     * **/
    public static void reload(){

        emptyAllMaps();

        // Regex for file name - starts with number, ends with .txt
        Pattern pattern = Pattern.compile("^([0-9]+)\\.txt$");

         // Scans the user database directory for user files
        File databseDirectory = new File(LOCATION);
        for(File file : databseDirectory.listFiles()){

            // Attempts to match file name regex with a file
            Matcher matcher = pattern.matcher(file.getName());
            if(matcher.find()){
                load(file);
            }
        }
        System.out.println("All Loaded");
    }

    /* loads database from directory into respective maps */
    public static void load(File userFile){
        try {

            String id = userFile.getName().replace(".txt","");
            int integerId = Integer.parseInt(id);

            // Creates new object depending on what type of user as indicated by the username
            // adds user to corresponding map
            Users users = null;
            if(id.startsWith("1")){
                Admin admin = new Admin();
                ADMINS.put(integerId,admin);
                users = admin;
            }else if(id.startsWith("2")){
                Doctor doctor = new Doctor();
                DOCTORS.put(integerId, doctor);
                users = doctor;
            }else if(id.startsWith("3")){
                Patient patient = new Patient();
                PATIENTS.put(integerId,patient);
                users = patient;
            }else if(id.startsWith("4")){
                Assistant assistant = new Assistant();
                ASSISTANTS.put(integerId,assistant);
                users = assistant;
            }
            else if(id.startsWith("5")) {
            	Nurse nurse = new Nurse();
            	NURSES.put(integerId, nurse);
            	users = nurse;
            	
            }

            
            // Scans each line in txt and sets the corresponding data
            Scanner scanner = new Scanner(userFile);
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            String password = scanner.nextLine();
            String email = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            String address = scanner.nextLine();
            users.setUserID(integerId);
            users.setFirstName(firstName);
            users.setLastName(lastName);
            users.setPassword(password);
            users.setEmail(email);
            users.setAddress(address);
            users.setPhoneNum(phoneNumber);
            scanner.close();

            USERS.put(integerId,users);
            System.out.println("Database Loaded User: "+integerId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /* returns user ID from the general USERS map */
    public static Users getUser(Integer userId){
        return USERS.get(userId);
    }

    /* returns ID of admin from ADMINS map */
    public static Admin getAdmin(Integer userId){
        return ADMINS.get(userId);
    }

    /* returns ID of patient from PATIENTS map */
    public static Patient getPatient(Integer userId){
        return PATIENTS.get(userId);
    }
    
    public static Doctor getDoctor(Integer userId) {
    	return DOCTORS.get(userId);
    }
    
    public static Assistant getAssistant(Integer userId){
        return ASSISTANTS.get(userId);
    }

    /* returns ID of nurse from NURSE map */
    public static Nurse getNurse(Integer userId){
        return NURSES.get(userId);
    }

    /* returns true if the user ID exists in the USER map
     * should be true if user was loaded into the map */
    public static boolean userExists(Integer userId){
        return USERS.containsKey(userId);
    }

    /* returns a map of all users */
    public static Map getAllUsers() {
    	return USERS;
    }


    public static Map getAllDoctors() {
    	return DOCTORS;
    }
    
    public static Map getAllNurses() {
    	return NURSES;
    }
    
    public static Map getAllPatients() {
    	return PATIENTS;
    }

    /* returns the size of each map to count how many users are in the system */
    public static int getNumOfUsers(int role) {
    	switch(role) {
    	case 1:
    		return ADMINS.size();
    	case 2:
    		return DOCTORS.size();
    	case 3:
    		return PATIENTS.size();
    	case 4:
    		return ASSISTANTS.size();
    	case 5:
    		return NURSES.size();
    	default:
    		return -1;
    	}
    }
	
}

