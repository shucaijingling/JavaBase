package com.xuyi.springframework.beans;

public class BeanException extends Exception {

    public BeanException(String message, Throwable e) {
        super(message, e);
    }

    public BeanException(String message) {
        super(message);
    }
}
