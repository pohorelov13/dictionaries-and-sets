package main.exceptions;

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException() {
        super("EMPTY QUEUE");
    }
}
