package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName);

    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName);
}
