package com.xuyi.springframework.beans.factory;

import com.xuyi.springframework.beans.BeansException;

/**
 * bean 工厂 【接口】
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;
}
