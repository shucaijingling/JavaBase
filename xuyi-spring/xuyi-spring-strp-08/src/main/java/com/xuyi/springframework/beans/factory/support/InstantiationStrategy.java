package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor<?> ctor, Object[] args);
}
