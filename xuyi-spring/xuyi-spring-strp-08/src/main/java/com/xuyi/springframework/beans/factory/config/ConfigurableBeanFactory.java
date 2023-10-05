package com.xuyi.springframework.beans.factory.config;

import com.xuyi.springframework.beans.factory.HierarchicalBeanFactory;
import com.xuyi.springframework.beans.factory.support.BeanPostProcessor;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegister {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor processor);

    void destroySingletons();
}
