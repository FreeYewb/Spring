package com.spring4.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yewenbo
 * @title: CashierImpl
 * @projectName Spring
 * @description: TODO 事务传播
 * @date 2019/6/18  16:56
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {
        for(String isbn : isbns){
            bookShopService.purchase(username,isbn);

        }

    }
}
