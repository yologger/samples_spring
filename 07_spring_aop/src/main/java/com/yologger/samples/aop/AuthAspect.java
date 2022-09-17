package com.yologger.samples.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    @Pointcut("execution(* *.*(..))")
    public void targetJoin() {

    }

    @Around("targetJoin()")
    public void beforeLog(ProceedingJoinPoint proceedingJoinPoint) {
        // do something

        try {
            Object result = proceedingJoinPoint.proceed();

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
