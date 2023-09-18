package com.xuyi.springframework.beans.factory;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;
}
