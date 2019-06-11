package com.spring3.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mt
 * @title: VlidationAspect
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/11  16:22
 */




public class VlidationAspect {

    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validate" + Arrays.asList(joinPoint.getArgs()));
    }
}
