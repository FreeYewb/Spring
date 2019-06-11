package com.spring3.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mt
 * @title: LoggingAspect
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/11  13:09
 */

public class LoggingAspect {



    public void  beforMethod(JoinPoint joinPoint){
      String methodName = joinPoint.getSignature().getName();
      Object [] args =joinPoint.getArgs();
    System.out.println("The method " +methodName + " begins "+ Arrays.asList(args));
    }


    public void  afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " ends ");
    }


    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " ends  with " + result);
    }


    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " occurs excetion:  " + ex);
    }


//    @Around("execution(public int com.spring3.aop.ArithmeticCalculator.*(*,*))")
//    public Object aroundMethod(ProceedingJoinPoint pjd){
//        Object result = null;
//        String methodName = pjd.getSignature().getName();
//
//        try {
//            //前置通知
//            System.out.println("The method " +methodName + " begins "+ Arrays.asList(pjd.getArgs()));
//            //执行目标方法
//            result = pjd.proceed();
//            //返回通知
//            System.out.println("The method " +methodName + " ends  with " + result);
//        }catch (Throwable ex){
//            //异常通知
//            System.out.println("The method " +methodName + " occurs excetion:  " + ex);
//            throw  new RuntimeException(ex);
//        }
//        //后置通知
//        System.out.println("The method " +methodName + " ends ");
//
//        return result;
//    }
}
