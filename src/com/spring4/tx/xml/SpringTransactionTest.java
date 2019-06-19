package com.spring4.tx.xml;

import com.spring4.tx.xml.service.BookShopService;
import com.spring4.tx.xml.service.Cashier;
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
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext4-xml.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }


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
