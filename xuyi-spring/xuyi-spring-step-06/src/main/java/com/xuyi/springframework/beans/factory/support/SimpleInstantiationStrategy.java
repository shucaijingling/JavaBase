package com.xuyi.springframework.beans.factory.support;


import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * jdk实现 bean 实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        try {
            Class clz = beanDefinition.getBeanClass();
            if (ctor != null) {
                return clz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clz.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e) {
            throw new BeansException("jdk instance failed ");
        }
    }
}
