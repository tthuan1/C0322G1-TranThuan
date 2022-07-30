package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Pointcut("within(com.example.controller.BookController.*)")
    public void allMethodPointCut() {
    }
    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint){
        System.out.println("Start method "+
                joinPoint.getSignature().getName()+ "time"+ LocalDateTime.now());
    }
}
