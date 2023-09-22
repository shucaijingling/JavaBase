package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorBeforeInitializationBean(Object existingBean, String beanName);


    Object applyBeanPostProcessorAfterInitializationBean(Object existingBean, String beanName);
}
