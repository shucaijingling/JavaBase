package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 使用jdk实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e) {
            throw new BeansException("JDK instantiating failed : " + beanName);
        }
    }
}
