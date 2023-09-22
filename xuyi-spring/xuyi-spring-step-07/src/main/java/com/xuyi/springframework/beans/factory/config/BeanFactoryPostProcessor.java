package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
