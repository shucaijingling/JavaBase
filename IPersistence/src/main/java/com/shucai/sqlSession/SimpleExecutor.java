package com.shucai.sqlSession;

import com.shucai.config.BoundSql;
import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;
import com.shucai.utils.GenericTokenParser;
import com.shucai.utils.ParameterMapping;
import com.shucai.utils.ParameterMappingTokenHandler;

import java.sql.Connection;
import java.util.List;

public class SimpleExecutor implements Executor{
    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception {

        //1. 注册驱动，获取练级
        Connection connection = configuration.getDataSource().getConnection();

        //2. 获取sql语句 : select * from user where id = #{id} and username = #{username}
        //进行转转：select * from user where id = ? and username = ?
        //并且保存#{} 中的内容
        String sql = mappedStatement.getSql();
        BoundSql boundSql = getBoundSql(sql);
        return null;
    }

    /**
     * 完成对#{}的解析：
     *      1. 将#{}替换成?
     *      2. 解析出#{}的值进行存储
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
