package com.spring4.tx.xml.service.impl;

import com.spring4.tx.xml.service.BookShopService;
import com.spring4.tx.xml.service.Cashier;

import java.util.List;

/**
 * @author yewenbo
 * @title: CashierImpl
 * @projectName Spring
 * @description: TODO 事务传播
 * @date 2019/6/18  16:56
 */

public class CashierImpl implements Cashier {


    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purchase(username,isbn);

        }

    }
}
