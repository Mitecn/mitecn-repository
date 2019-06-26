package com.kb.sys.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class TestAspect {

	
	  @Around("whitin(com.kb.sys.service.*)") 
	  public Object around(ProceedingJoinPoint joinPoint)throws Throwable {
	  System.out.println("方法执行前"); Object result = joinPoint.proceed();
	  System.out.println("方法执行后"); return result; }
	 
}
