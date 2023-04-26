package com.shucai.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shucai.io.Resources;
import com.shucai.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * 使用dom4j将配置文件进行解析，封装成Configuration
     */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {
        //解析 sqlMapConfig.xml
        Document document = new SAXReader().read(inputStream);
        //<configuration>
        Element rootElement = document.getRootElement();
        //拿到任意位置的property
        List<Element> list = rootElement.selectNodes("//property");

        //创建容器用于保存property中的k-v  name-value
        Properties properties = new Properties();

        //遍历获取name和value的值
        //<property name="driverClass" value="com.mysql.cj.jdbc.Driver"></property>
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }

        //设置C3P0连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(properties.getProperty("driverClass"));
        dataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        dataSource.setUser(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));

        configuration.setDataSource(dataSource);

        //解析 Mapper.xml -- 拿到路径 -- 字节输入流 -- dom4j即系
        //<mapper resource="UserMapper.xml"></mapper>
        List<Element> mapper = rootElement.selectNodes("mapper");

        for (Element element : mapper) {
            //解析所有的 Mapper.xml
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourcesAsStream(mapperPath);

            //传入configuration用于封装statement
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            //调用解析成statement
            xmlMapperBuilder.parse(resourceAsStream);
        }
        return configuration;
    }
}
