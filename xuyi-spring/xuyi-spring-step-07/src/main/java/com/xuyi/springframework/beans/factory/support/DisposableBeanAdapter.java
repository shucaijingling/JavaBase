package com.xuyi.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.DisposableBean;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final String beanName;

    private final Object bean;

    private String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, String destroyMethodName) {
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public void destroy() throws Exception {
        //1. 实现接口 disposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        //2. 注解配置 destroy-method 【判断避免二次执行销毁】
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("destroy failed ");
            }
            destroyMethod.invoke(bean);
        }

    }
}
