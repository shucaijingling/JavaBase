package com.xuyi.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanPostProcessor;
import com.xuyi.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 实例化 bean
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    /**
     * cglib 实例化 bean
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            //实例化
            bean = createBeanInstance(beanName, beanDefinition, args);

            //属性填充
            applyPropertyValues(beanName, bean, beanDefinition);

            //执行 bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        }catch (Exception e) {
            throw new BeansException("[AbstractAutowireCapableBeanFactory createBean] failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e) {
            throw new BeansException("[AbstractAutowireCapableBeanFactory applyPropertyValues] failed : " + beanName);
        }
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {

        Constructor constructorToUse = null;
        Class clazz = beanDefinition.getBeanClass();
        //获取构造器
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        //1、 执行 BeanPostProcessor before 处理
        Object wrappedBean = applyBeanPostProcessorBeforeInitialization(bean, beanName);

        //todo、 invokeInitMethods
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        //2、 执行 BeanPostProcessor after 处理
        wrappedBean = applyBeanPostProcessorAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            return current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            return current;
        }
        return result;
    }
}
