/**
 * Represents the patient.
 *
 */
public class Patient extends Users
{
    private int patientID = 200;
    /**
     * Class constructor.
     */
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