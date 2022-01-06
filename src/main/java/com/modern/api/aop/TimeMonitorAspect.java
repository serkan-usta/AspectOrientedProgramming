package com.modern.api.aop ;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TimeMonitorAspect {

  @Around("@annotation(TimeMonitor)")
  public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Starting " + joinPoint.getSignature().toShortString());
    System.out.println(joinPoint.getSignature().getName() + " input -> " + Arrays.toString((int[])joinPoint.getArgs()[0]));
    long start = System.nanoTime();
    Object proceed = joinPoint.proceed();
    long executionTime = System.nanoTime() - start;
    System.out.println(joinPoint.getSignature().getName() + "ed -> " + Arrays.toString((int[])joinPoint.getArgs()[0]));
    System.out.println(joinPoint.getSignature().getName() + " took: " + executionTime + " ns\n");
    return proceed;
  }
}
