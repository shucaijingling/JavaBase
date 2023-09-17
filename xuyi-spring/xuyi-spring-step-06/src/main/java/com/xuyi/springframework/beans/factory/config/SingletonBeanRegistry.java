package com.xuyi.springframework.beans.factory.config;

/**
 * 注册单例bean接口
 */
public interface SingletonBeanRegistry {


    /**
     * 获取单例bean
     */
    Object getSingleton(String beanName);
}
