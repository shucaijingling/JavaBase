package com.xuyi.springframework.test;

import com.xuyi.springframework.BeanDefinition;
import com.xuyi.springframework.BeanFactory;
import com.xuyi.springframework.test.bean.UserService;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2. 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");

        //4. 执行bean方法
        userService.queryUserInfo();
    }
}
