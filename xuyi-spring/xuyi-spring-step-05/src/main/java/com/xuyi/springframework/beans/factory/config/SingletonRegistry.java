package com.xuyi.springframework.beans.factory.config;

/**
 * 注册单例接口
 */
public interface SingletonRegistry {

    Object getSingleton(String beanName);
}
