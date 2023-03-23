package main.exceptions;

public class NoSuchOrderException extends RuntimeException {
    public NoSuchOrderException() {
        super("NO SUCH ORDER EXIST");
    }

    public NoSuchOrderException(String message) {
        super(message);
    }
}
