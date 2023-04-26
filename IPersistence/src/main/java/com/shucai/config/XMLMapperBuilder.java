package com.shucai.config;

import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    //定义解析方法
    public void parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);

        /**
         *  <mapper namespace="user">
         *  <select id="selectOne" paramType="com.shucai.pojo.User" resultType="com.shucai.pojo.User">
         *         select * from user where id = #{id} and username = #{username}
         *     </select>
         */
        //封装所有sql
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");

        List<Element> list = rootElement.selectNodes("//select");

        for (Element element : list) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramType = element.attributeValue("paramType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParameterType(paramType);
            mappedStatement.setSql(sqlText);
            //设置唯一statementId  namespace.id
            String statementId = namespace + "." + id;
            configuration.getMappedStatementMap().put(statementId , mappedStatement);


        }
    }
}
