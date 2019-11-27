import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {


    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
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
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer1");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object obj = moodConstructor.newInstance(message1, message2);
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
        }catch (IllegalArgumentException e){
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS);
        }

        return null;
    }


    public static MoodAnalyzer createMoodAnalyzer(String message1, String message2, String message3) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object obj = moodConstructor.newInstance(message1, message2,message3);
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
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        return null;
    }

    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(String.class);
            Object obj = moodConstructor.newInstance(message);
            return (MoodAnalyzer) obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        return null;
    }

    public static Object invokeMethod(Object moodAnalysisObject, String methodName ) throws  MoodAnalyzerException {
        try {
            return moodAnalysisObject.getClass().getMethod(methodName).invoke(moodAnalysisObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, "Define Proper method");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.METHOD_INVOCATION_ISSUE, "May be issue with Data entered", e);
        }
    }

    public static void setFieldValue(Object myobject, String fieldName, String fieldValue) throws MoodAnalyzerException {
        try {
            Field field = myobject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myobject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD, "Define Proper Field Name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS, e);
        }

    }


}