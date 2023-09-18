package com.xuyi.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.xuyi.springframework.beans.BeansException;
import com.xuyi.springframework.beans.PropertyValue;
import com.xuyi.springframework.beans.factory.config.BeanDefinition;
import com.xuyi.springframework.beans.factory.config.BeanReference;
import com.xuyi.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.xuyi.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.xuyi.springframework.core.io.Resource;
import com.xuyi.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * xml BeanDefinition 读取器
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        try {
            doLoadBeanDefinitions(inputStream);
        } catch (ClassNotFoundException | BeansException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void loadBeanDefinitions(Resource... resources) throws IOException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws IOException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws IOException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 解析标签
     * @param inputStream
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, BeansException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) continue;
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");

            //用于初始化BeanDefinition
            Class<?> clz = Class.forName(className);

            //设置beanName
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                //id和name都没设置beanName 就取 类名，首字母小写
                beanName = StrUtil.lowerFirst(clz.getSimpleName());
            }

            //解析属性
            BeanDefinition beanDefinition = new BeanDefinition(clz);
            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {

                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                Object value = StrUtil.isEmpty(attrValue) ? new BeanReference(attrRef) : attrValue;
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(attrName, value));
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("duplicate beanDefinition : " + beanName);
            }

            //注册到 BeanDefinition 注册中心
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }

    }

}
