package com.xuyi.springframework.context.support;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.xuyi.springframework.beans.factory.config.BeanPostProcessor;
import com.xuyi.springframework.context.ConfigurableApplicationContext;
import com.xuyi.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.util.Map;

/**
 * 应用上下文抽象类实现
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws IOException, BeansException {
        //1. 创建 BeanFactory 并加载 BeanDefinition
        refreshBeanFactory();

        //2. 获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        //3. 在 Bean 实例化前 执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        //4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        //5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

    }



    protected abstract void refreshBeanFactory() throws IOException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requireType) throws BeansException {
        return getBeanFactory().getBean(beanName, requireType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

}
