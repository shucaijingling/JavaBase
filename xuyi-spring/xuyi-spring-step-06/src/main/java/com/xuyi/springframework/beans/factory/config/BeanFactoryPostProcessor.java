package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * beanFactory后置处理器
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后 ， 实例化 bean 之前 提供修改 BeanDefinition 的属性的机制
     * @param beanFactory
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
