
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users
{
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private int userID;  

    public Users()
    {

    }

    public Users(int userID, String firstname, String lastname,  String password)
    
    {
        setUserID(userID);
        setUsername(firstname, lastname);
        this.password = password;
    }
    
    public Users(String firstName, String lastName, String password) {
    	setFirstName(firstName);
    	setLastName(lastName);
    	this.password = password;
    }

    //========================= GETTER METHODS ==============================================

    public String getUsername()
    {
        return username;
    }
    
    public int getUserID()
    {
        return userID;
    }

    public String getPassword()
    {
        return password;
    }

    public String getfirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }

    // ======================================================================================

    //============================== SETTER METHODS =========================================
    public void setUserID(int userID)
    {
        this.userID = userID;
    }
    
    public void setFirstName(String firstName)
    {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
    	this.lastName = lastName;
    }


    public void setUsername(String firstName, String lastName)
    
    {
        /*
        Sets the username based of person's first name and last name.
        Example: John Doe = john.doe

        TODO: Need to add a check if two people have the same full name. Will do it after we have our database (txt files) ready. 
        */
        if (firstName.length() > 0 && lastName.length() > 0)
        {
            this.username = firstName + "." + lastName;
        }
        
    }

    public void setPassword(String password) throws IOException
    {/* Checks if the passowrd is matching the requirements (is atleast 8 characters long and contains a special character/number).
        Otherwise, throws an exception
    */

        Pattern p = Pattern.compile("[A-Za-z0-9!@#$%&*_<>-]");
        Matcher m = p.matcher(password);
        boolean b = m.find();
        
        if (password.length() > 8 && b == true)
        {
            this.password = password;
        }
        throw new IOException("Password needs to be atleast 8 characters long and have atleast 1 number or a special character.");
        
    }
    

    // ==============================================================================================================================
}  
