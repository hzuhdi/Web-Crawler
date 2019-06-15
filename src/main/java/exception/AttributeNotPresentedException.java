package exception;

public class AttributeNotPresentedException extends RuntimeException {
    public AttributeNotPresentedException(String message)
    {
        super(message);
    }
}
