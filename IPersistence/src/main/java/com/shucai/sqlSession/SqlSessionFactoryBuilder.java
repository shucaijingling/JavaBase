package com.shucai.sqlSession;

import com.shucai.config.XMLConfigBuilder;
import com.shucai.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream in) throws DocumentException, PropertyVetoException {
        //第一，使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);


        //第二，创建sqlSessionFactory
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return defaultSqlSessionFactory;
    }


}
