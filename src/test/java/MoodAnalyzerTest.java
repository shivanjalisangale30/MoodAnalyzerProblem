import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {
    @Test
    public void givenMessage_whenSad_shouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try {
            Assert.assertEquals("Sad", moodAnalyzer.analyseMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood ");
        try {
            Assert.assertEquals("Happy", moodAnalyzer.analyseMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_whenNullMood_shouldReturnHappy() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            Assert.assertEquals("Happy", moodAnalyzer.analyseMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_NullPointerException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyzerException.class);
            moodAnalyzer.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenMessage_EmptyPointerEcxeption() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            moodAnalyzer.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_whenProper_shouldReturnObject() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer1 = MoodAnalyzerFactory.createMoodAnalyzer();
        MoodAnalyzer moodAnalyzer2 = new MoodAnalyzer();
        boolean result = moodAnalyzer1.equals(moodAnalyzer2);
        Assert.assertTrue(result);
    }

    @Test
    public void givenClassName_whenImproper_shouldThrowException() throws MoodAnalyzerException {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClassName_whenImproperConstructor_shouldThrowException() throws MoodAnalyzerException {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("String1","String2");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }


}