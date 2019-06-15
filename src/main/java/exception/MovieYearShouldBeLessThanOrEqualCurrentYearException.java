package exception;

public class MovieYearShouldBeLessThanOrEqualCurrentYearException extends RuntimeException{
    public MovieYearShouldBeLessThanOrEqualCurrentYearException(String message) {
        super(message);
    }
}
