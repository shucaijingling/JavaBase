package com.xuyi.springframework.beans.factory.config;

public interface SingletonBeanRegister {

    Object getSingleton(String beanName);

    void destroySingletons();
}
