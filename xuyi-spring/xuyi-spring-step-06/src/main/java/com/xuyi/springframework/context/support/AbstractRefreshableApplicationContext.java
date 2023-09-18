package com.xuyi.springframework.context.support;

import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.io.IOException;

/**
 * 获取 BeanFactory ，加载资源
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    //BeanDefinition注册中心
    private DefaultListableBeanFactory beanFactory;
    @Override
    protected void refreshBeanFactory() throws IOException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws IOException;

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
