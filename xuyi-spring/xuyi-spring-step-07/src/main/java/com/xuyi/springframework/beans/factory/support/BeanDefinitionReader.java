package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.core.io.Resource;
import com.xuyi.springframework.core.io.ResourceLoader;

import java.io.IOException;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegister();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(String location) throws IOException;
    void loadBeanDefinitions(String... locations) throws IOException;
    void loadBeanDefinitions(Resource resource) throws IOException, ClassNotFoundException;
    void loadBeanDefinitions(Resource... resources) throws IOException;

}
