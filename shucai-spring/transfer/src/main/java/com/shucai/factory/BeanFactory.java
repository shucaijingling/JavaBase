package com.shucai.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂类，使用反射创建对象
 */
public class BeanFactory {
    /**
     * 1. 读取解析xml，通过反射实例化对象并存储
     * 2. 对外提供获取实例的接口（根据id）
     */

    private static Map<String, Object> map = new HashMap<>();

    static {
        //加载xml
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        //解析xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(in);
            Element rootElement = document.getRootElement();
            List<Element> beanList = rootElement.selectNodes("//bean");
            for (Element element : beanList) {
                //从xml中获取id和class
                String id = element.attributeValue("id");
                String clzName = element.attributeValue("class");

                //通过反射实例化对象
                Class<?> clzz = Class.forName(clzName);
                Object o = clzz.newInstance();

                //保存到map
                map.put(id, o);
            }
        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //对外提供获取实例对象的接口
    public static Object getBean(String id) {
        return map.get(id);
    }
}
