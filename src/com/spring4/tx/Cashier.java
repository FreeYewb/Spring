package com.spring4.tx;

import java.util.List;

/**
 * @author yewenbo
 * @title: Cashier
 * @projectName Spring
 * @description: TODO 事务传播
 * @date 2019/6/18  16:53
 */
public interface Cashier {
    public void checkout(String username, List<String> isbns);

}
