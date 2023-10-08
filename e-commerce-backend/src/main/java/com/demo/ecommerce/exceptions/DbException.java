package com.demo.ecommerce.exceptions;

public class DbException extends Exception {

    public DbException(String message) {
        super(message);
    }

    public DbException(Throwable cause) {
        super(cause);
    }
}
