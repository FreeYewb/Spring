package com.spring2.aop.impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect//再声明为一个切面
@Component//把这个类声明为一个切面：需要把该类放入到IOC容器中
public class LoggingAspect {
	//声明该方法是一个前置通知：在目标方法开始之前执行
	@Before("execution(* com.spring2.aop.impl.*.*(int , int ))")
	public void beforeMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method "+methodName+"begins" + args);
 	}
	
	//后置通知：在目标方法执行后（无论是否发生异常），执行的通知
	//在后置通知中还不能访问目标方法执行的结果
	@After("execution(* com.spring2.aop.impl.*.*(int , int ))")
	public void  afterMethod(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println("The method "+methodName+"ends" );
	}
}
