package com.wgc.springboottest.dto.response;


import com.wgc.springboottest.utils.ResultCode;

import java.io.Serializable;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
public class ResultVo<T> implements Serializable {

    private static final int STATUS_SUCCESS = 1;
    private static final int STATUS_FAILURE = 0;


    // 业务code标志 例如服务器错误500 没权限403等等
    private int code;
    // 本次接口是否成功 成功1 失败 0
    private int state;
    private String message;
    private T data;

    public static <T> ResultVo<T> faild() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultCode.FAILURE);
        resultVo.setState(STATUS_FAILURE);
        resultVo.setMessage(ResultCode.FAILURE.getMessage());
        return resultVo;
    }

    public static <T> ResultVo<T> faild(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultCode.FAILURE);
        resultVo.setState(STATUS_FAILURE);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static <T> ResultVo<T> faild(int code, String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setState(STATUS_FAILURE);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static <T> ResultVo<T> success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultCode.SUCCESS);
        resultVo.setMessage(ResultCode.SUCCESS.getMessage());
        resultVo.setState(STATUS_SUCCESS);
        return resultVo;
    }

    public static <T> ResultVo<T> success(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setData(data);
        resultVo.setCode(ResultCode.SUCCESS);
        resultVo.setMessage(ResultCode.SUCCESS.getMessage());
        resultVo.setState(STATUS_SUCCESS);
        return resultVo;
    }

    public static <T> ResultVo<T> success(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultCode.SUCCESS);
        resultVo.setMessage(message);
        resultVo.setState(STATUS_SUCCESS);
        return resultVo;
    }

    public int getCode() {
        return code;
    }

    public ResultVo<T> setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
