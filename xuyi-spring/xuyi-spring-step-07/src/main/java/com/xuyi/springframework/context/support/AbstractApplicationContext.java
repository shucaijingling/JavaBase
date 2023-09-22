package com.xuyi.springframework.context.support;

import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.xuyi.springframework.beans.factory.config.BeanPostProcessor;
import com.xuyi.springframework.context.ConfigurableApplicationContext;
import com.xuyi.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() {

        //1. 创建BeanFactory, 加载 BeanDefinition
        refreshBeanFactory();

        //2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3. 在 Bean 实例化之前 执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //4. 在其他 Bean 注册之前，注册 BeanPostProcessor
        registerBeanPostProcessors(beanFactory);

        //5. 提前实例化单例Bean
        beanFactory.preInstantiateSingleton();
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeanOfType(BeanPostProcessor.class);
        for (BeanPostProcessor processor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(processor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeanOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor processor : beanFactoryPostProcessorMap.values()) {
            processor.postProcessorBeanFactory(beanFactory);
        }
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory();


    @Override
    public Object getBean(String beanName) {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requireType) {
        return getBeanFactory().getBean(beanName, requireType);
    }

    @Override
    public <T> Map<String, T> getBeanOfType(Class<T> type) {
        return getBeanFactory().getBeanOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }
}
