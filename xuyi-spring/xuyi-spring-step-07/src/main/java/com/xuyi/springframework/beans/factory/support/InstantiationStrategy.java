package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args);
}
