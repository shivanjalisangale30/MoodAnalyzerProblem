public class MoodAnalyzerException extends Exception {
    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FEILD , NO_ACCESS
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
