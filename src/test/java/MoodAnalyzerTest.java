import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    @Test
    public void givenMessage_whenSad_shouldReturnSad()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try
        {
            Assert.assertEquals("Sad", moodAnalyzer.analyseMood(null));
        }
        catch (MoodAnalyzerException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood ");
        try
        {
            Assert.assertEquals("Happy", moodAnalyzer.analyseMood(null));
        }
        catch (MoodAnalyzerException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_whenNullMood_shouldReturnHappy()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try
        {
            Assert.assertEquals("Happy", moodAnalyzer.analyseMood(null));
        } catch (MoodAnalyzerException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_NullPointerException()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL , e.type);
        }
    }

    @Test
    public void givenMessage_EmptyPointerEcxeption()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY , e.type);
        }
    }
}