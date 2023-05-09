package com.wgc.springboottest.exception;

import com.wgc.springboottest.utils.ResultCode;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
public class BusinessException extends RuntimeException{
    private final ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public BusinessException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BusinessException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.resultCode = resultCode;
    }

}
