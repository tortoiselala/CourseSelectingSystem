package cn.tortoise.dto;

public class LoginResult {
    private boolean status;
    private String message;

    public LoginResult(boolean status) {
        this.status = status;
        this.message = "login success";
    }

    public LoginResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
