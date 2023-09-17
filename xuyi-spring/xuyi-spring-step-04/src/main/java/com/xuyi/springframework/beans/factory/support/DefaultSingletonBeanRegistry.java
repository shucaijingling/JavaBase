package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册单例bean 默认实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 单例池，用于存储已经注册的bean
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 从缓存中获取单例bean
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 存到缓存中
     */
    protected void addSingleton(String beanName, Object bean) {
        this.singletonObjects.put(beanName, bean);
    }
}
