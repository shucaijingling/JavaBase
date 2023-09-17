package com.xuyi.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory    {

    /**
     * 使用cglib策略进行实例化
     */
    private CglibSubclassInstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //通过反射直接进行无参实例化
            bean = beanDefinition.getBeanClass().newInstance();
            //填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        }catch (Exception e) {
            throw new BeansException("create bean failed without args " + beanName);
        }
        //添加到单例池
        addSingleton(beanName, bean);
        return bean;
    }


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        }catch (Exception e) {
            throw new BeansException("createBean failed with args : " + beanName);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * cglib进行实例化
     */
    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor constructorToUse = null;
        Class clazz = beanDefinition.getBeanClass();
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            if (declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 对实例化的bean进行属性填充
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) throws BeansException {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                /**
                 * 递归进行属性填充
                 */
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    //有引用，会走getBean获取该bean， 1.先从单例池霍去病， 2. 单例池没有走create bean进行创建
                    value = getBean(beanReference.getName());
                }

                //填充属性
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e) {
            throw new BeansException("apply propertyValue failed : " + beanName);
        }
    }

    public CglibSubclassInstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

}
