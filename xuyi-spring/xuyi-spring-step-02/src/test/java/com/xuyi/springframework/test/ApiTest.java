package com.xuyi.springframework.test;

import com.xuyi.springframework.beans.BeanException;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xuyi.springframework.test.bean.UserService;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() throws BeanException {
        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        //4. 第二次获取bean from Singleton
        UserService userServiceSingleton = (UserService) beanFactory.getBean("userService");
        userServiceSingleton.queryUserInfo();
    }
}
