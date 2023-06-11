package com.shucai.test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.shucai.mapper.MPUserMapper;
import com.shucai.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MPTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        MPUserMapper mapper = sqlSession.getMapper(MPUserMapper.class);
        List<User> all = mapper.finAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void MPtest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        /**
         * mp 不是MybatisSqlSessionFactoryBuilder() 会报错，产生的sqlsession不是plus的！！！
         */
        SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        MPUserMapper mapper = sqlSession.getMapper(MPUserMapper.class);
        List<User> users = mapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
