package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanPostProcessor;
import com.xuyi.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requireType) {
        return (T) getBean(beanName);
    }


    private <T> T doGetBean(String beanName, Object[] args) {
        Object bean = getSingleton(beanName);
        if (null != bean) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    @Override
    public void addBeanPostProcessor(BeanPostProcessor processor) {
        beanPostProcessors.remove(processor);
        beanPostProcessors.add(processor);
    }
}
