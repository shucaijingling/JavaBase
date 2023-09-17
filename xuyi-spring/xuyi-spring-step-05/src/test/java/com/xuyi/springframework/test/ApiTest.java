package com.xuyi.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xuyi.springframework.beans.xml.XmlBeanDefinitionReader;
import com.xuyi.springframework.core.io.DefaultResourceLoader;
import com.xuyi.springframework.core.io.FileSystemResource;
import com.xuyi.springframework.core.io.Resource;
import com.xuyi.springframework.test.beans.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = new FileSystemResource("src/test/resource/important.properties");
        InputStream inputStream = resource.getInputStream();
        String testContent = IoUtil.readUtf8(inputStream);
        System.out.println(testContent);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/shucaijingling/JavaBase/blob/master/algorithm/src/main/java/code/Code23_MergeKSortedLists.java");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() throws BeansException {
        //1、初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2、读取配置文件&注册bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        //3、获取bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
