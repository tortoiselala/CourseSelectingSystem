package cn.tortoise.dto;


public class RequestResult <T> {
    private boolean success;
    private T data;
    private String message;

    public RequestResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public RequestResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
