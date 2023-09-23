package com.xuyi.springframework.beans.factory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeanOfType(Class type);


    String[] getBeanDefinitionNames();
}
