import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer1");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor();
            Object obj = moodConstructor.newInstance();
            return (MoodAnalyzer) obj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static MoodAnalyzer createMoodAnalyzer(String message1, String message2) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object obj = moodConstructor.newInstance(message1, message2);
            return (MoodAnalyzer) obj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD);
        }

        return null;
    }


}