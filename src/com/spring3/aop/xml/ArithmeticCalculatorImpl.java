package com.spring3.aop.xml;

import org.springframework.stereotype.Component;


public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
//		System.out.println("the method add begins with["+i+","+j+"]");
		int result = i + j;
//		System.out.println("the method add ends with" + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		int result = i / j;
		return result;
	}

}
