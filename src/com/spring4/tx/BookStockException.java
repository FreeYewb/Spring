package com.spring4.tx;

/**
 * @author mt
 * @title: BookStockException
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/14  15:04
 */
public class BookStockException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
