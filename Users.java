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
        Pattern p = Pattern.compile("[A-Za-z0-9");
        Matcher m = p.matcher(password)
        boolean b = m.find();
        
        if (passowrd.length() > 8 && b == true)

        {
            this.password = password;
        }
        throw IOException("Password needs to be atleast 8 characters long and have atleast 1 number or a special character.");
        
    }


}