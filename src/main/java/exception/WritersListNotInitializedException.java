package exception;

public class WritersListNotInitializedException extends RuntimeException {
    public WritersListNotInitializedException(String message) {
        super(message);
    }
}
