package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.SingletonRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取单例
 */
public abstract class DefaultSingletonRegistry implements SingletonRegistry {

    /**
     * 创建单例池
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取单例
     */
    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    /**
     * 添加到单例池
     */
    protected void addSingleton(String beanName, Object bean) {
        this.singletonObjects.put(beanName, bean);
    }
}
