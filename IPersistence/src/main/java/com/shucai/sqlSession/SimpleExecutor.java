package com.shucai.sqlSession;

import com.shucai.config.BoundSql;
import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;
import com.shucai.utils.GenericTokenParser;
import com.shucai.utils.ParameterMapping;
import com.shucai.utils.ParameterMappingTokenHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {

        //1. 注册驱动，获取练级
        Connection connection = configuration.getDataSource().getConnection();

        //2. 获取sql语句 : select * from user where id = #{id} and username = #{username}
        //进行转转：select * from user where id = ? and username = ?
        //并且保存#{} 中的内容
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);

        //3. 获取预处理对象 preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getSqlText());

        //4.设置参数
        //获取填充对象的全路径
        String parameterType = mappedStatement.getParameterType();
        Class<?> parameterTypeClass = getClassType(parameterType);
        //获取参数列表
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            //第一个参数名select * from user where id = #{id} and username = #{username}
            //id
            String parameterName = parameterMappingList.get(i).getContent();
            //通过反射获取值
            Field declaredField = parameterTypeClass.getDeclaredField(parameterName);
            declaredField.setAccessible(true);
            Object o = declaredField.get(params[0]);
            preparedStatement.setObject(i+1, o);
        }

        //5.执行sql
        ResultSet resultSet = preparedStatement.executeQuery();

        //6.封装返回结果集
        //获取返回类型
        String resultType = mappedStatement.getResultType();
        Class<?> resultTypeClass = getClassType(resultType);

        //创建数组，保存返回对象
        ArrayList<Object> objects = new ArrayList<>();

        while (resultSet.next()) {
            Object o = resultTypeClass.newInstance();

            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                //字段名
                String columnName = metaData.getColumnName(i);
                //值
                Object value = resultSet.getObject(columnName);

                //使用反射或内省，根据数据库表和实体的对应关系，进行封装
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o, value);
            }
            objects.add(o);
        }

        return (List<E>) objects;
    }

    private Class<?> getClassType(String parameterType) throws ClassNotFoundException {
        //paramType="com.shucai.pojo.User"
        if (parameterType != null) {
            Class<?> aClass = Class.forName(parameterType);
            return aClass;
        }
        return null;
    }

    /**
     * 完成对#{}的解析：
     * 1. 将#{}替换成?
     * 2. 解析出#{}的值进行存储
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        //标记处理类： 配置标记解析器来完成对占位符的解析处理工作
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        //解析出的sql
        String parseSql = genericTokenParser.parse(sql);

        //#{}解析出来的参数名称
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();

        BoundSql boundSql = new BoundSql(parseSql, parameterMappings);
        return boundSql;
    }
}
