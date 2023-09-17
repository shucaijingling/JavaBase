package com.xuyi.springframework.test;

import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.PropertyValues;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanReference;
import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xuyi.springframework.test.bean.UserDao;
import com.xuyi.springframework.test.bean.UserService;
import org.testng.annotations.Test;

public class ApiTest {


    @Test
    public void test_BeanFactory() throws BeansException {

        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2. userDao 注册
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        //3. userService 注册
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        //4. 获取userService 执行方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
