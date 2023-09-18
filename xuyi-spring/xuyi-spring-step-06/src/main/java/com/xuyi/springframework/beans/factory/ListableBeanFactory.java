package com.xuyi.springframework.beans.factory;

import com.xuyi.springframework.beans.BeansException;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    /**
     * 根据类型返回bean实例
     * @param type
     * @return
     * @param <T>
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    String[] getBeanDefinitionNames();

}
