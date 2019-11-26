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

    public String analyseMood()
    {
        try
        {
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
            return "Happy";
        }
   }
}
