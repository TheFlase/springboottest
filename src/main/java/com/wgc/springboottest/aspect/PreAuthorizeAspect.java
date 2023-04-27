package com.wgc.springboottest.aspect;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/4/25
 **/
@Aspect
@Component
@Slf4j
@Order(1000)
public class PreAuthorizeAspect {
    @Around("@annotation(com.wgc.springboottest.aspect.HasPermissions)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            HasPermissions annotation = method.getAnnotation(HasPermissions.class);
            String permissionSelect = annotation.value();
            if(StrUtil.equalsIgnoreCase("permissionSelect",permissionSelect)){
                joinPoint.proceed();
            }else {
                throw new RuntimeException("没有查询权限，请核实后再试！");
            }
    }
}
