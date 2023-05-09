package com.wgc.springboottest.exception;

import com.wgc.springboottest.dto.response.ResultVo;
import com.wgc.springboottest.utils.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ResultVo exceptionHandleer(HttpServletRequest httpServletRequest, Exception e){
        if(e instanceof UndeclaredThrowableException){
            e = (Exception) ((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        String message = e.getMessage();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().setHeader("resultCode", "-1");
        return ResultVo.faild(message);
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ResultVo exceptionHandleer(HttpServletRequest httpServletRequest, BusinessException e){
        String message = e.getMessage();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        servletRequestAttributes.getResponse().setHeader("resultCode", "-2");
        return ResultVo.faild(-1,message);
    }

}
