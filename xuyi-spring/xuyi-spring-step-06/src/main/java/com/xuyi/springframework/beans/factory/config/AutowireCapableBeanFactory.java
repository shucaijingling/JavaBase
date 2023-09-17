package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {


    /**
     * 执行 BeanPostProcessors 接口实现类的  applyBeanPostProcessorBeforeInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     */
    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName);


    /**
     * 执行 BeanPostProcessors 接口实现类的 applyBeanPostProcessorAfterInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     */
    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName);
}
