package com.xuyi.springframework.beans.factory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    /**
     * 根据类型返回bean实例
     * @param type
     * @return
     * @param <T>
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);


    String[] getBeanDefinitionNames();

}
