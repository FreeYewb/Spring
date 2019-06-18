package com.spring4.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author yewenbo
 * @title: SpringTransactionTest
 * @projectName Spring
 * @description: TODO
 * @date 2019/6/14  15:07
 */
public class SpringTransactionTest {
    private ApplicationContext ctx = null;
    private  BookShopDao bookShopDao = null;
    private  BookShopService bookShopService = null;
    private  Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }
    //使用propagation 指定事务的传播行为，即当前的事务方法被另一个事务方法掉调用时
    //如何使用事务，默认取值为REQUIRED，使用调用方法的事务
    //REQUIRES_NEW:事务自己的事务，调用的事务方法的事务被挂起
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Test
    public void testTransactionlPropagation(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }

    @Test
    public  void  testBookShopService(){
        bookShopService.purchase("AA","1001");
    }
    @Test
    public void testBookShopDaoFindPriceByIsbn(){
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }
    @Test
    public void testBookShopDaoUpateBookStock(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public  void testBookShopDaoupdateUserAccount(){
        bookShopDao.updateUserAccount("AA",100);
    }
}
