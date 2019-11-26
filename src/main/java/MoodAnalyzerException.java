public class MoodAnalyzerException extends Throwable
{
  enum ExceptionType
  {
      ENTERED_NULL , ENTERED_EMPTY
  }

  ExceptionType type;

  public MoodAnalyzerException(ExceptionType type , String message)
  {
      super(message);
      this.type = type;
  }
}
