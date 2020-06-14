package exception;

public class AllowedWritersNumberExceededException extends RuntimeException{
    public AllowedWritersNumberExceededException(String message) {
        super(message);
    }
}
