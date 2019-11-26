import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void givenMessage_whenSad_shouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        Assert.assertEquals("Sad",moodAnalyzer.analyseMood());
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturnHappy()
    {
       MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
       String mood = moodAnalyzer.analyseMood();
       Assert.assertEquals("Happy" , mood);
    }
}