package com.xuyi.springframework.beans.factory.config;

/**
 * 单例注册接口，定义
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
