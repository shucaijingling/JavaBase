package com.shucai.test;

import com.shucai.io.Resources;
import com.shucai.pojo.User;
import com.shucai.sqlSession.SqlSession;
import com.shucai.sqlSession.SqlSessionFactory;
import com.shucai.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class IPersistenceTest {

    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        User user2 = sqlSession.selectOne("user.select", user);

    }
}
