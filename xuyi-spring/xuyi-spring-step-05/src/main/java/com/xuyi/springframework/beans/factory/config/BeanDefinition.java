package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.PropertyValues;

/**
 * bean 定义信息
 */
public class BeanDefinition {

    /**
     * bean class类型 用于实例化，不直接定义Object 跟实例化行为解耦
     */
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
