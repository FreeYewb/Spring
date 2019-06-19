package com.spring4.tx.xml;

/**
 * @author mt
 * @title: UserAccountException
 * @projectName Spring
 * @description: TODO yewenbo
 * @date 2019/6/14  15:12
 */
public class UserAccountException extends  RuntimeException {

    private static final long serialVersionUID = 1L;
    public UserAccountException() {
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
