package cn.tortoise.model.dto;

public class ExecuteResult {
    private boolean success;
    private String message;

    public ExecuteResult(boolean success) {
        this.success = success;
        this.message = "execute success";
    }

    public ExecuteResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExecuteResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
