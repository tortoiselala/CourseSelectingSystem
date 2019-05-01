package cn.tortoise.exceptions;

import cn.tortoise.dto.ExecuteResult;

public class ExecuteException extends Exception{
    public ExecuteException() {
    }

    public ExecuteException(String message) {
        super(message);
    }

    public ExecuteException(String message, Throwable cause) {
        super(message, cause);
    }
}
