package com.easy.common;

import java.io.Serializable;

public class CommonResult implements Serializable{
    private int code; 
    private String message;
    private Object data;

    public CommonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static CommonResult success(int code, String message, Object data) {
        return new CommonResult(code, message, data);
    }
    public static CommonResult success(int code, String message) {
        return new CommonResult(code, message, null);
    }
    public static CommonResult success(Object data) {
        return new CommonResult(200, "�����ɹ�", data);
    }
    public static CommonResult success() {
        return new CommonResult(200, "�����ɹ�", null);
    }

    public static CommonResult fail(int code, String message, Object data) {
        return new CommonResult(code, message, data);
    }
    public static CommonResult fail(int code, String message) {
        return new CommonResult(code, message, null);
    }
    public static CommonResult fail(){
        return new CommonResult(400,"操作失败",null);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
