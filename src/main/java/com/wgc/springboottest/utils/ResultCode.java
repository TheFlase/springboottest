package com.wgc.springboottest.utils;

import com.wgc.springboottest.constant.Constant;

import java.io.Serializable;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/5/9
 **/
public class ResultCode implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private Object[] params = null;
    public static final ResultCode PARAM_VERIFY_ERROR = new ResultCode(500010, "参数校验错误");
    public static final ResultCode IS_NULL = new ResultCode(500002, "参数错误");
    public static final ResultCode SUCCESS;
    public static final ResultCode FAILURE;
    public static final ResultCode PARAM_VALID_ERROR;
    public static final ResultCode UN_AUTHORIZED;
    public static final ResultCode NOT_FOUND;
    public static final ResultCode MSG_NOT_READABLE;
    public static final ResultCode METHOD_NOT_SUPPORTED;
    public static final ResultCode MEDIA_TYPE_NOT_SUPPORTED;
    public static final ResultCode REQ_REJECT;
    public static final ResultCode INTERNAL_SERVER_ERROR;
    public static final ResultCode PARAM_MISS;
    public static final ResultCode PARAM_TYPE_ERROR;
    public static final ResultCode PARAM_BIND_ERROR;

    public ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String toString() {
        return "ResultCode{code=" + this.code + ", message='" + this.message + '\'' + '}';
    }

    static {
        SUCCESS = new ResultCode(200, Constant.DEFAULT_SUCCESS_MESSAGE);
        FAILURE = new ResultCode(500001, "业务异常");
        PARAM_VALID_ERROR = new ResultCode(400001, "参数校验失败");
        UN_AUTHORIZED = new ResultCode(401, "请求未授权");
        NOT_FOUND = new ResultCode(404, "404 没找到请求%name%");
        MSG_NOT_READABLE = new ResultCode(400, "消息不能读取");
        METHOD_NOT_SUPPORTED = new ResultCode(405, "不支持当前请求方法");
        MEDIA_TYPE_NOT_SUPPORTED = new ResultCode(415, "不支持当前媒体类型");
        REQ_REJECT = new ResultCode(403, "请求被拒绝");
        INTERNAL_SERVER_ERROR = new ResultCode(500003, "服务器异常");
        PARAM_MISS = new ResultCode(400, "缺少必要的请求参数");
        PARAM_TYPE_ERROR = new ResultCode(400, "请求参数类型错误");
        PARAM_BIND_ERROR = new ResultCode(400, "请求参数绑定错误");
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

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
