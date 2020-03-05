

import java.io.IOException;
import java.security.KeyStore.TrustedCertificateEntry;
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

    public Users(int userID, String username, String passwords)
    
    {
        setUserID(userID);
        setUsername(username);
        setPassword(password);
    }
    
    public Users(String firstName, String lastName, String password) {
    	setFirstName(firstName);
    	setLastName(lastName);
    	setPassword(password);
    }



    public String getUsername()
    {
        return username;
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


    public void setUsername(String username)
    
    {
        /*
        Need to create a check for already existing usernames.
        */


        if (username.length() < 12)
        {
            this.username = username;
        }
        
    
    }

    public void setPassword(String password)
    
    {
        Pattern p = Pattern.compile("[A-Za-z0-9!@#$%&*_<>-]");
        Matcher m = p.matcher(password);
        boolean b = m.find();
        
        if (password.length() > 8 && b == true)
        {
            this.password = password;
        }
        //throw  IOException("Password needs to be atleast 8 characters long and have atleast 1 number or a special character.");
        
    }
    
    static boolean verifyPassword(String pass) {
    	if (pass.length() > 8)
        {
           return true;
        }

    	return false;
    	
    }
    
    static boolean verifyName(String name) {
    	if (name.length() > 0)
        {
           return true;
        }
    	
    	return false;	
    }


=======
import java.io.IOException;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users
{
    private String username;
    private String password;
    private String userID;  
    public Users()
    {

    }

    public Users(String userID, String username, String passwords)
    
    {
        setUserID(userID);
        setUsername(username);
        setPassword(password);
    }

    public String getUserID(String userID)
    {
        return userID;
    }

    public String getUsername(String username)
    {
        return username;
    }
    public String getPassword(String password)
    {
        return password;
    }


    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public void setUsername(String username)
    
    {
        /*
        Need to create a check for already existing usernames.
        */


        if (username.length() < 12)
        {
            this.username = username;
        }
        
    
    }

    public void setPassword(String password)
    
    {
        Pattern p = Pattern.compile("[A-Za-z0-9!@#$%&*_<>-]");
        Matcher m = p.matcher(password);
        boolean b = m.find();
        
        if (passowrd.length() > 8 && b == true)
        {
            this.password = password;
        }
        throw IOException("Password needs to be atleast 8 characters long and have atleast 1 number or a special character.");
        
    }


}