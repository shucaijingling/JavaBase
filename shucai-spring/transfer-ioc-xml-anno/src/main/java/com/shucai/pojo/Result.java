package com.shucai.pojo;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Result implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String status;

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("register bean id : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory: " + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext : " + applicationContext);
    }

    public void initMethod() {
        System.out.println("init-method...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod");
    }
}
