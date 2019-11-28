import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

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
    public void givenDefaultConstructor_whenProper_shouldReturnObject() throws MoodAnalyzerException {
        Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
        Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//        MoodAnalyzer moodAnalyzer1 = MoodAnalyzerFactory.createMoodAnalyzer();
        MoodAnalyzer moodAnalyzer2 = new MoodAnalyzer();
        boolean result = myObject.equals(moodAnalyzer2);
        Assert.assertTrue(result);
    }

    @Test
    public void givenDefaultConstructor_whenImproperClassName_shouldThrowException() throws MoodAnalyzerException {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenClassName1_whenImproperConstructor_shouldThrowException() throws MoodAnalyzerException {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("String1","String2");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenParameterConstructor_whenProper_shouldReturnObject() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//            MoodAnalyzer moodAnalyzer1 = MoodAnalyzerFactory.createMoodAnalyzer("String1" , "String2");
            MoodAnalyzer moodAnalyzer2 = new MoodAnalyzer();
            boolean result = myObject.equals(moodAnalyzer2);
            Assert.assertTrue(result);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenParameterConstructor_whenImproperClassName_shouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("String1","String2");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.type);
        }

    }

    @Test
    public void givenClassName2_whenImproperConstructor_shouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
//            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("String1","String2","String3");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMessage_whenProperInvokeMethod_shouldReturnHappy() throws MoodAnalyzerException {
        Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
        Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
        Object mood = MoodAnalyzerFactory.invokeMethod(myObject , "analyseMood");
        Assert.assertEquals("Happy", mood);
    }

    @Test
    public void givenHappyMessage_whenImproperInvokeMethod_shouldReturnException() throws MoodAnalyzerException {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
            Object mood = MoodAnalyzerFactory.invokeMethod(myObject, "analyseMood123");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_OnChangedMood_shoudlReturnHappy() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
            MoodAnalyzerFactory.setFieldValue(myObject, "message", "I am in Happy Mood");
            Object mood = MoodAnalyzerFactory.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_whenImproperSetField_shouldHandleException() throws MoodAnalyzerException {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor(String.class);
            Object myObject = MoodAnalyzerFactory.createMoodAnalsyser(constructor, "I am in Happy Mood");
            MoodAnalyzerFactory.setFieldValue(myObject, "message1", "I am in Happy Mood");
            Object mood = MoodAnalyzerFactory.invokeMethod(myObject, "analyseMood");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_FEILD, e.type);

        }
    }

}
