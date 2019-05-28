package exception;

public class IDException extends Exception{
    public IDException() {
        super();
    }

    public IDException(String message) {
        super(message);
    }

    public IDException(String message, Throwable cause) {
        super(message, cause);
    }

    public IDException(Throwable cause) {
        super(cause);
    }

    protected IDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
