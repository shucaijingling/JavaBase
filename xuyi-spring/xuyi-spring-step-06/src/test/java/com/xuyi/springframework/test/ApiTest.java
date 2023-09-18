package com.xuyi.springframework.test;

import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xuyi.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.xuyi.springframework.context.support.ClassPathXmlApplicationContext;
import com.xuyi.springframework.test.beans.UserService;
import com.xuyi.springframework.test.common.MyBeanFactoryPostProcessor;
import com.xuyi.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {


    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() throws IOException {

        //1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2. 读取配置文件 注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //3、BeanDefinition 加载完成 & Bean实例化前，修改 BeanDefinition 属性
        MyBeanFactoryPostProcessor processor = new MyBeanFactoryPostProcessor();
        processor.postProcessBeanFactory(beanFactory);

        //4. Bean 实例化后， 修改 Bean 属性
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        //5. 获取 bean 对象  调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        String s = userService.queryUserInfo();
        System.out.println(s);
    }


    @Test
    public void test_xml() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = context.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println(s);
    }
}
