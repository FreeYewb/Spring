package com.spring2.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @ClassName:  Main
 * @version:（版本，具体版本信息自己来定）
 * @Description: （对类进行功能描述）
 * @author: yewenbo （作者）
 * @date: 2019年6月10日下午4:35:54（日期）
 */
public class Main {
	public static void main(String[] args) {
		//1.创建spring 的IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		//2.IOC 容器中获取bean 的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		//3.使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println(result);
		
		result = arithmeticCalculator.div(12, 6);
		System.out.println(result);
		
	}
}
