package com.wgc.springboottest.exception;

import com.wgc.springboottest.vo.ResultVo;
import com.wgc.springboottest.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{

    @ExceptionHandler({Exception.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultVo exceptionHandleer(Exception e){
        log.error("全局异常信息 ex=" + e.getMessage(), e);
        if(e instanceof UndeclaredThrowableException){
            e = (Exception) ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().setHeader("resultCode", String.valueOf(ResultCode.INTERNAL_SERVER_ERROR));
        return ResultVo.faild(ResultCode.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVo<?> businessException(BusinessException e) {
        log.error("业务处理异常信息 ex=" + e.getMessage(), e);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().setHeader("resultCode", String.valueOf(e.getResultCode().getCode()));
        return ResultVo.faild(e.getResultCode().getCode(), e.getMessage(), e.getResultCode().getParams());
    }

    @ExceptionHandler({FeignException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVo<?> feginException(FeignException e) {
        log.error("fegin调用异常信息 ex=" + e.getMessage(), e);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().setHeader("resultCode", String.valueOf(e.getResultCode().getCode()));
        return ResultVo.faild(e.getResultCode().getCode(), e.getMessage(), e.getResultCode().getParams());
    }

}
