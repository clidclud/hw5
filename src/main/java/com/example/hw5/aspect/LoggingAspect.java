package com.example.hw5.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.hw5.controller.PersonController.*(..))")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        logger.info("Controller method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.example.hw5.service.PersonService.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        logger.info("Service method called: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* com.example.hw5.service.PersonService.*(..))", returning = "result")
    public void logAfterServiceMethod(JoinPoint joinPoint, Object result) {
        logger.info("Service method finished: " + joinPoint.getSignature().getName() + " with result: " + result);
    }
}
