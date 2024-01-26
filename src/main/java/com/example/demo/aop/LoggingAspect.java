package com.example.demo.aop;


import com.example.demo.entity.AuditLog;
import com.example.demo.repository.AuditLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Pointcut("@annotation(com.example.demo.aop.LogMethodExecution)")
    public void logPointcut() {
    }

    @Before("logPointcut()")
    public void logMethodBeforeCalls(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs()).forEach(o -> System.out.println("arg value: " + o.toString()));
    }

    @AfterReturning(value = "logPointcut()", returning = "response")
    public void logMethodReturnValue(JoinPoint joinPoint, Object response) {
        AuditLog auditLog = AuditLog.builder()
                .methodArgument(String.valueOf(Arrays.stream(joinPoint.getArgs()).findFirst()))
                .response(String.valueOf(response))
                .build();
        auditLogRepository.save(auditLog);
    }
}
