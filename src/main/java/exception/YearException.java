package exception;

public class YearException extends Exception {

    public YearException() {
        super();
    }

    public YearException(String message) {
        super(message);
    }

    public YearException(String message, Throwable cause) {
        super(message, cause);
    }

    public YearException(Throwable cause) {
        super(cause);
    }

    protected YearException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

