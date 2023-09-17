package com.xuyi.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * bean 实例化 [创建bean]
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 创建cglib策略
     */
    private CglibSubclassInstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
            //属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("instance failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            //属性填充
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("instance with args failed");
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * 属性填充
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                //属性名
                String name = propertyValue.getName();
                //属性值
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    //A 依赖 B 获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("error setting property values : " + beanName);
        }
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Constructor constructorToUser = null;
        Class clazz = beanDefinition.getBeanClass();
        try {
            for (Constructor ctor : clazz.getDeclaredConstructors()) {
                if (args != null && ctor.getParameterTypes().length == args.length) {
                    constructorToUser = ctor;
                    break;
                }
            }
        } catch (Exception e) {
            throw new BeansException("[createBeanInstance] failed");
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUser, args);
    }

    public CglibSubclassInstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(CglibSubclassInstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
