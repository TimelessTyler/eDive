package com.example.edives.bean;

public class ApplyBean {
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ApplyBean{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
