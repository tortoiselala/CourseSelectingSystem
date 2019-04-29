package cn.tortoise.exceptions;

public class IllegalArgumentCheckedException extends Exception{
    public IllegalArgumentCheckedException() {
    }

    public IllegalArgumentCheckedException(String message) {
        super(message);
    }

    public IllegalArgumentCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
