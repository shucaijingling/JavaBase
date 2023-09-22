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

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws IOException {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws IOException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        try {
            doLoadBeanDefinition(inputStream);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws IOException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }


    private void doLoadBeanDefinition(InputStream inputStream) throws ClassNotFoundException {
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

            String beanName = StrUtil.isNotBlank(id) ? id : name;
            Class<?> clz = Class.forName(className);
            if (StrUtil.isBlank(beanName)) {
                beanName = StrUtil.lowerFirst(clz.getSimpleName());
            }

            BeanDefinition beanDefinition = new BeanDefinition(clz);

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;

                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                Object value = StrUtil.isBlank(attrValue) ? new BeanReference(attrRef) : attrValue;
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(attrName, value));
            }
            if (getRegister().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate BeanDefinition");
            }
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
