package com.xuyi.springframework.beans.factory.config;

/**
 * bean定义信息
 */
public class BeanDefinition {

    /**
     * 将Object替换为Class，可以把bean的实例化操作放在容器中处理
     */
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
