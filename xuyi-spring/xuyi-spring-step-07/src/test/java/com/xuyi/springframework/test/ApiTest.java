package com.xuyi.springframework.test;

import com.xuyi.springframework.context.support.ClasspathXmlApplicationContext;
import com.xuyi.springframework.test.bean.UserService;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void test_xml() throws IOException {
        //1. 注册 BeanFactory 加载 bd
        ClasspathXmlApplicationContext applicationContext = new ClasspathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        //2. 获取 bean 执行方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println(s);
    }
}