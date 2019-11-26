public class MoodAnalyzer
{
    private String message;

    public MoodAnalyzer()
    {

    }

    public MoodAnalyzer(String message)
    {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalyzerException
    {
        this.message=message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyzerException
    {
        try
        {
            if (message.length() == 0 )
            {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY, "Please enter proper message");
            }
            if (this.message.contains("Sad"))
            {
                return "Sad";
            }
            else
            {
                return "Happy";
            }
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_NULL , "Please enter proper message.");
        }
   }


}
