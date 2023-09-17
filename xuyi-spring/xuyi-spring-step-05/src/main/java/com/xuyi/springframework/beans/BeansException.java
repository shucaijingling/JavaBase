package com.xuyi.springframework.beans;

/**
 * 自定义异常
 */
public class BeansException extends Exception{

    public BeansException() {
        super();
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
