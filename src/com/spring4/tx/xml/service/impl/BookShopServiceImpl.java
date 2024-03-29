package com.spring4.tx.xml.service.impl;

import com.spring4.tx.xml.BookShopDao;
import com.spring4.tx.xml.service.BookShopService;

/**
 * @author mt
 * @title: BookShopServiceImpl
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/14  17:31
 */

public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    public void purchase(String username, String isbn) {

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //2.更新书的余额
        bookShopDao.updateBookStock(isbn);
        //3.更新用户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
