package com.tortoise.enums;

public enum StatusEnum {
    SUCCESS(1, ""),
    END(0, ""),
    REPEAT_SELECT(-1, ""),
    INNER_ERROR(-2, ""),
    DATA_WRITE(-3, "");


    private int status;
    private String info;

    StatusEnum(int status, String info) {
        this.status = status;
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static StatusEnum valuesOf(int index){
        for(StatusEnum e : values()){
            if(e.getStatus() == index){
                return e;
            }
        }
        return null;
    }
}
