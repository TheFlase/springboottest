package com.wgc.springboottest.exception;

import com.wgc.springboottest.utils.ResultCode;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
public class FeignException extends RuntimeException{
    private final ResultCode resultCode;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public FeignException(String message) {
        super(message);
        this.resultCode = ResultCode.FAILURE;
    }

    public FeignException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public FeignException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.resultCode = resultCode;
    }

}
