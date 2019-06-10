package com.spring2.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
* @ClassName:  Main 
* @version:���汾������汾��Ϣ�Լ������� 
* @Description: ��������й��������� 
* @author: yewenbo �����ߣ� 
* @date: 2019��6��10������4:35:54�����ڣ�
 */
public class Main {
	public static void main(String[] args) {
		//1.����spring ��IOC����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		//2.IOC �����л�ȡbean ��ʵ��
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		//3.ʹ��bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println(result);
		
		result = arithmeticCalculator.div(12, 6);
		System.out.println(result);
		
	}
}
