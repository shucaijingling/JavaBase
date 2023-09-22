package com.xuyi.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.InitializingBean;
import com.xuyi.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            applyPropertyValue(beanName, bean, beanDefinition);
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("AbstractAutowireCapableBeanFactory createBean failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // before
        Object wrappedBean = applyBeanPostProcessorBeforeInitializationBean(bean, beanName);

        // bean 对象的初始化方法
        try {
            invokeInitMethods(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("invoke init methods failed with bean :  " + beanName);
        }

        //after
        wrappedBean = applyBeanPostProcessorAfterInitializationBean(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        //1. 实现接口， InitializingBean
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }

        //2. 注解配置 init-method 【避免二次初始化】
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName) && !(bean instanceof InitializingBean)) {

            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);

            if (null == initMethod) {
                throw new BeansException("Could not find an init-method : " + initMethodName + " with bean : " + beanName);
            }

            initMethod.invoke(bean);
        }

    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorRes = null;
        Class clz = beanDefinition.getBeanClass();
        for (Constructor constructor : clz.getDeclaredConstructors()) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorRes = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorRes, args);
    }

    private void applyPropertyValue(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("AbstractAutowireCapableBeanFactory applyPropertyValue failed");
        }
    }

    @Override
    public Object applyBeanPostProcessorBeforeInitializationBean(Object existingBean, String beanName) {
        return null;
    }

    @Override
    public Object applyBeanPostProcessorAfterInitializationBean(Object existingBean, String beanName) {
        return null;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
