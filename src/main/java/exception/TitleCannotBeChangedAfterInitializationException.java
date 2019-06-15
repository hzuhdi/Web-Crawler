package exception;

public class TitleCannotBeChangedAfterInitializationException extends RuntimeException {
    public TitleCannotBeChangedAfterInitializationException(String message) {
        super(message);
    }
}
