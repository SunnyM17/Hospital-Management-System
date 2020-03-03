import java.io.IOException;

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
        if (username.length() < 12)
        {
            this.username = username;
        }
        
    
    }

    public void setPassword(String password)
    
    {
        if (passowrd.length() > 8)
        {
            this.password = password;
        }
        throw IOException("Password needs to be atleast 8 characters long.");
        
    }


}