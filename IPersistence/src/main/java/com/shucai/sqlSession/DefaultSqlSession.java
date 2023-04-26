package com.shucai.sqlSession;

import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;

import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {

        //完成SimpleExecutor对query的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {

        List<Object> objects = this.selectList(statementId, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        }else {
            throw new RuntimeException("select error");
        }
    }
}
