
/**
 * Represents the doctor.
 *
 */
public class Doctor extends Users
{
	
    private int doctorID = 100;

    /**
     * Class Constructor
     */
    public Doctor()
    {
        super.getUserID();
    }


    /**
     * Sets the Doctor's ID that beings with 1.
     */
    public void setDoctorID()
    {
       
       
       super.setUserID(doctorID);
       doctorID += 1;
    }


}