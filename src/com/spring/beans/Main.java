package com.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2019/05/22 15 :07
 * 
 * @author Administrator
 *
 */
public class Main {
    public static void main(String[] args) {
        // 这些操作可以交给Spring完成
        // 创建HelloWorld 的一个对象
        // HelloWorld hl = new HelloWorld();
        // 为name属性赋值
        // hl.setName("yewb");

        // 1、创建Spring 的IOC容器对象
        // ApplicationContext代表IOC容器
        // ClassPathXmlApplicationContext：是ApplicationContext 接口的实现类.该实现类从类路径下来加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2、从IOC容器中获取Bean实例
        // 利用id定位到IOC容器中的实例
        // HelloWorld hl = (HelloWorld) ctx.getBean("helloWorld");
        // 利用类型返回IOC容器中的Bean，当要求IOC容器中必须只能有一个该类型的Bean
        // HelloWorld helloWorld =hl.getBean(HelloWorld.class);
        // 3、调用hello方法
        // hl.hello();

        Car car =(Car) ctx.getBean("car");
        System.out.println(car);
        
        car = (Car) ctx.getBean("car2");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
        

    }

}
