package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.core.io.DefaultResourceLoader;
import com.xuyi.springframework.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader extends DefaultListableBeanFactory implements BeanDefinitionReader{

    private BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegister() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
