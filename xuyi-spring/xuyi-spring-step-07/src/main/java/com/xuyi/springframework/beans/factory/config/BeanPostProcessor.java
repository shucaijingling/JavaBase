package com.xuyi.springframework.beans.factory.config;

public interface BeanPostProcessor {

    Object postProcessorBeforeInitialization(Object bean, String beanName);

    Object postProcessorAfterInitialization(Object bean, String beanName);
}
