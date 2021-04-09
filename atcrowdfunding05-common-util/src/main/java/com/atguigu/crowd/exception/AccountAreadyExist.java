package com.atguigu.crowd.exception;

public class AccountAreadyExist extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountAreadyExist(String message) {
        super(message);
    }

    public AccountAreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountAreadyExist(Throwable cause) {
        super(cause);
    }

    protected AccountAreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
