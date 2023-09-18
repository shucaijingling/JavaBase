package com.xuyi.springframework.test.common;

import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {

        BeanDefinition userService = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = userService.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：字节跳动"));
    }
}
