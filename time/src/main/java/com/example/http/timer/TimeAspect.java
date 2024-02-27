package com.example.http.timer;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j

public class TimeAspect {
    @Pointcut("within(@com.example.http.timer.Timer *)")
    public void beanAnnotated() {
    }

    @Pointcut("@annotation(com.example.http.timer.Timer)")
    public void methodAnnotated() {
    }


    @Around("beanAnnotated() || methodAnnotated()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Метод {} выполняется за {} миллисекунд", joinPoint.getSignature().getName(), elapsedTime);
        return result;
    }
}
