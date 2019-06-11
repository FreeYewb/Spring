package com.spring3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author mt
 * @title: LoggingAspect
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/11  13:09
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    /**
     * 在com.spring3.aop.ArithmeticCalculator接口的每一个实现类的每一个方法开始之前执行一段代码
     */
    @Before("execution(public int com.spring3.aop.ArithmeticCalculator.*(*,*))")
    public void  befprMethod(JoinPoint joinPoint){
      String methodName = joinPoint.getSignature().getName();
      Object [] args =joinPoint.getArgs();
    System.out.println("The method " +methodName + " begins "+ Arrays.asList(args));
    }

    /**
     * 在方法执行之后执行的代码，无论该方法是否出现异常
     * @param joinPoint
     */
    @After("execution(public int com.spring3.aop.ArithmeticCalculator.*(*,*))")
    public void  afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " ends ");
    }

    /**
     * 在方法正常结束后执行的代码叫返回通知，返回通知是可以访问到方法的返回值的
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(public int com.spring3.aop.ArithmeticCalculator.*(*,*))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " ends  with " + result);
    }

    /**
     *在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定在出现特定异常时在执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public int com.spring3.aop.ArithmeticCalculator.*(*,*))",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " +methodName + " occurs excetion:  " + ex);
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjd
     */
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
