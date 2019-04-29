package cn.tortoise.exceptions;

public class UserParameterErrorException extends Exception{
    public UserParameterErrorException() {
        super();
    }

    public UserParameterErrorException(String message) {
        super(message);
    }

    public UserParameterErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
