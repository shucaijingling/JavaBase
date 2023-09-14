package com.xuyi.springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取单例对象的接口
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 实现一个受保护的addSingleton方法，可以被继承此类的其他类调用：
     *  包括：AbstractBeanFactory以及继承的DefaultListableBeanFactory调用
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
