package com.spring4.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mt
 * @title: SpringTransactionTest
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/14  15:07
 */
public class SpringTransactionTest {
    private ApplicationContext ctx = null;
    private  BookShopDao bookShopDao = null;
    private  BookShopService bookShopService = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
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
