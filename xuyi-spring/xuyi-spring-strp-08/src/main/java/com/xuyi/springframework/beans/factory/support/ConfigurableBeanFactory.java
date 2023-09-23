package com.xuyi.springframework.beans.factory.support;

import com.xuyi.springframework.beans.factory.HierarchicalBeanFactory;
import com.xuyi.springframework.beans.factory.config.SingletonBeanRegister;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegister {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor processor);

}
