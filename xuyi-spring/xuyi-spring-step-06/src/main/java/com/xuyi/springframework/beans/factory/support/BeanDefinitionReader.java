package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.core.io.Resource;
import com.xuyi.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * BeanDefinition 读取器
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws IOException;

    void loadBeanDefinitions(Resource... resources) throws IOException;

    void loadBeanDefinitions(String location) throws IOException;


    void loadBeanDefinitions(String... locations) throws IOException;
}
