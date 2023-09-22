package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) {
        try {
        Class clz = beanDefinition.getBeanClass();
            if (null != ctor) {
                return clz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e) {
            throw new BeansException("JDK instantiate failed");
        }
    }
}
