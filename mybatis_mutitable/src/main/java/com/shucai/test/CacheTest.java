package com.shucai.test;

import com.shucai.mapper.IUserMapper;
import com.shucai.muti.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {

    private SqlSession sqlSession;

    private IUserMapper iUserMapper;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = build.openSession(true);
        iUserMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @Test
    public void firstLevelCacheTest(){
        User user1 = iUserMapper.findById(1);

        User user2 = iUserMapper.findById(1);

        //一级缓存，返回值相同 user1 == user2 --> true
        System.out.println(user1 == user2);


    }
}
