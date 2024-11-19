package com.example.springdemowebbasic.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author rival
 * @since 2024-11-15
 */
@Aspect
@Component
@Log4j2
public class ExecutionTimeLoggingAspect {

    @Around("execution(* com.example.springdemowebbasic.controller.AopController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 메서드 실행
        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // 로깅
        log.info("========================================================================");
        log.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
