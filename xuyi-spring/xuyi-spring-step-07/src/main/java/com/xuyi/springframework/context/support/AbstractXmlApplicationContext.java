package com.xuyi.springframework.context.support;

import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xuyi.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.io.IOException;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws IOException {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            reader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
