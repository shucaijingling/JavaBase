package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.BeanDefinition;

/**
 * 注册bean定义信息
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
