public class MoodAnalyzerException extends Exception {
    public MoodAnalyzerException(ExceptionType noSuchFeild, ExceptionType type) {
    }

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FEILD , NO_ACCESS , METHOD_INVOCATION_ISSUE , OBJECT_CREATION_ISSUE
    }

    ExceptionType type;

    public MoodAnalyzerException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public MoodAnalyzerException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public MoodAnalyzerException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

    public MoodAnalyzerException(ExceptionType noSuchClass) {
        super(noSuchClass.toString());
        this.type = noSuchClass;
    }

}
