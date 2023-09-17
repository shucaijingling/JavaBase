package com.xuyi.springframework.beans.factory.config;

public interface BeanPostProcessor {

    /**
     * 在 bean 初始化 之前执行此方法
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessBeforeInitialization(Object bean, String beanName);

    /**
     * 在 bean 初始化后 执行
     * @param bean
     * @param beanName
     * @return
     */
    Object postProcessAfterInitialization(Object bean, String beanName);
}
