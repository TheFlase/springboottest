package com.wgc.springboottest.exception;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
public class BusinessException extends RuntimeException{

    private int code;
    private String msg;


    public BusinessException(int code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code,String message,  String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
