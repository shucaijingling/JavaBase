package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * JDK实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {

        Object bean = null;
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                bean = clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                bean = clazz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e) {
            throw new BeansException("JDK instance failed");
        }
        return bean;
    }
}
