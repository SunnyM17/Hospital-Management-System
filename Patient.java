public class Patient extends Users
{
    private int patientID = 200;
    public Patient()
    {
        super.getUserID();
    }

    public void setPatientID()
    {
        
        super.setUserID(patientID);
        patientID += 1;
    }
}