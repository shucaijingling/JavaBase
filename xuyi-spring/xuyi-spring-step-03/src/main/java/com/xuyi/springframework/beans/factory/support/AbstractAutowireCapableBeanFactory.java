package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.BeanException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

/**
 * 实例化Bean类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    public Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean = null;
        try {
            //无参构造， issue#1:构造器有参该如何处理？
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
