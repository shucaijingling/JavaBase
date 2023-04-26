package com.shucai.sqlSession;

import com.shucai.pojo.Configuration;
import com.shucai.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;
}
