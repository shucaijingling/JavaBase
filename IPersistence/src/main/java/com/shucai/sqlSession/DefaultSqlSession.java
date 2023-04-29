package com.shucai.sqlSession;

import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;

import java.lang.reflect.*;
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

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理为Dao生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //构建statementId
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();
                String statementId = className+"."+methodName;
                //获取被调用方法的返回值类型
                Type type = method.getGenericReturnType();
                //如果返回值类型还有泛型，就返回list
                if (type instanceof ParameterizedType) {
                    return selectList(statementId, args);
                }
                return selectOne(statementId,args);
            }
        });
        return (T) proxyInstance;
    }
}
