package com.spring3.aop.xml;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mt
 * @title: Main
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/1111:26
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        int result = arithmeticCalculator.add(1,2);
        System.out.println("result "+ result);

        result = arithmeticCalculator.div(1000,10);
        System.out.println("result "+ result);
    }


}
