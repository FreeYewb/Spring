package com.spring4.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author mt
 * @title: BookShopDapImpl
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/14  14:45
 */
@Repository("BBookShopDao")
public class BookShopDaoImpl implements BookShopDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {

        String sql = " select  price from book where isbn = ?";

        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        //检查书的库存是否足够，若不够，则抛出异常
        String sq2 = "select stock from book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(sq2,Integer.class,isbn);
        if (stock == 0){
            throw  new BookStockException("库存不足");
        }


        String sql = " update book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price) {
        //验证余额是否足够，若不足，则抛出异常
        String Sql2 = "select balance from account where username = ?";
        int balance = jdbcTemplate.queryForObject(Sql2,Integer.class,username);
        if (balance < price){
            throw  new UserAccountException("余额不足");
        }
    String sql = "update account set balance = balance - ? where username = ?";
    jdbcTemplate.update(sql,price,username);
    }
}
