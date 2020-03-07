public class Assistant extends Users
{
    private int assistantID = 400;

    public Assistant()
    {

    }

    public void setAssistantID()
    {
        super.setUserID(assistantID);
        assistantID += 1;
    }
    
}