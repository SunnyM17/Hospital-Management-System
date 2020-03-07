public class Nurse extends Users
{
    private int nurseID = 500;

    public Nurse()
    {

    }

    public void setNurseID()
    {
        super.setUserID(nurseID);
        nurseID += 1;
    }
}
