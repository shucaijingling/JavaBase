package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.BeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;

/**
 * 模板方法： 抽象工厂
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {

    /**
     * 从单例池中获取bean，没有就创建
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }


    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
