package exception;

public class InvalidMenuItem extends RuntimeException {
    public InvalidMenuItem(String message) {
        super(message);
    }
}
