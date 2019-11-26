import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void givenMessage_whenSad_shouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood =moodAnalyzer.analyseMood("I am in Sad Mood");
        Assert.assertEquals("Sad",mood);
    }
}