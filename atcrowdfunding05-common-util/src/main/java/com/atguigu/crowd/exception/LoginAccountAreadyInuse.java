package com.atguigu.crowd.exception;

public class LoginAccountAreadyInuse extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LoginAccountAreadyInuse(String message) {
        super(message);
    }

    public LoginAccountAreadyInuse(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAccountAreadyInuse(Throwable cause) {
        super(cause);
    }

    protected LoginAccountAreadyInuse(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
