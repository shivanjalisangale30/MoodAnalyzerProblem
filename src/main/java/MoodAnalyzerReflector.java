import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerReflector {

    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyzer");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static Object createMoodAnalsyser(Constructor<?> constructor, Object... message) throws MoodAnalyzerException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.OBJECT_CREATION_ISSUE, e);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS, e);
        }
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
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FEILD, "Define Proper Field Name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS, e);
        }catch (NullPointerException e){
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.ENTERED_NULL,e);
        }

    }


}