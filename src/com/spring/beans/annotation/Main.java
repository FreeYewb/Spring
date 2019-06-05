package com.spring.beans.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.annotation.controller.UserController;

public class Main {
    public static void main(String[] args) {
        // ApplicationContext ctx = new
        // ClassPathXmlApplicationContext("/Spring-1/src/beans-annotation.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController controller = (UserController) ctx.getBean("userController");
        System.out.println(controller);
        controller.execute();
//
//        UserService service = (UserService) ctx.getBean("userService");
//        System.out.println(service);

        // UserRepository impl = (UserRepository) ctx.getBean("userRepository");
        // System.out.println(impl);
    }
}
