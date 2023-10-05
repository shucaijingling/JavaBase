package com.xuyi.springframework.beans.factory.config;

public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public final String getBeanName() {
        return beanName;
    }
}
