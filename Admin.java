public class Admin extends Users
{
    private int adminID = 300;
        
    }
    public Admin()
    {
        super.getUserID();
    }

    public void setAdminID()
    {
        
        super.setUserID(adminID);
        adminID += 1;
    }
}