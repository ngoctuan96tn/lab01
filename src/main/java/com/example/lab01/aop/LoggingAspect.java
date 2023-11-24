package com.example.lab01.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.lab01.service.*.*(..))")
    private void serviceMethods() {

    }

    @Before("serviceMethods()")
    public void logBefore() {
        logger.info("Before method execution");
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfter(Object result) {
        logger.info("After method execution with result: {}", result);
    }
}
