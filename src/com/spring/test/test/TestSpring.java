package com.spring.test.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.test.pojo.JuiceMaker;
import com.spring.test.pojo.Source;
import com.spring.test.pojo.Student;
import com.spring.test.pojo.StudentConfig;
import com.spring.test.service.ProductService;
import com.spring.test.service.StudentService;
import com.spring.test.service.StudentServiceImpl;
import com.spring.test.service.TeacherServiceImpl;

public class TestSpring {
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContexttest.xml"}) ;
		
		Source source = (Source) ctx.getBean("source",Source.class);
		System.out.println(source.getFruit());
		System.out.println(source.getSize());
		System.out.println(source.getSugar());
		
		JuiceMaker juiceMaker = (JuiceMaker) ctx.getBean("juice");
		System.out.println(juiceMaker.makeJuice());
		
		ProductService productService = (ProductService) ctx.getBean("productService");
		productService.doSomeService();
		
	}
	@Test
	public void test1() {
			ApplicationContext ctxApplicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContexttest.xml"}) ;
//			StudentService studentService = (StudentService) ctxApplicationContext.getBean("student1");
			StudentService studentService =  ctxApplicationContext.getBean("studentService",TeacherServiceImpl.class);
			studentService.printStudentInfo();								
	}
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentService studentService =  context.getBean("studentService", StudentServiceImpl.class);
        studentService.printStudentInfo();
	}
}
