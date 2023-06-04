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

//@CacheNamespace(implementation = RedisCache.class)
public class CacheTest {

    private SqlSession sqlSession;

    private IUserMapper iUserMapper;

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
        iUserMapper = sqlSession.getMapper(IUserMapper.class);
    }

    @Test
    public void firstLevelCacheTest(){
        User user1 = iUserMapper.findById(1);

        User user2 = iUserMapper.findById(1);

        //一级缓存，返回值相同 user1 == user2 --> true
        System.out.println(user1 == user2);
    }
    @Test
    public void firstLevelCacheTest2() {
        User user1 = iUserMapper.findById(1);

        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        iUserMapper.update(user);
        sqlSession.commit();

        User user2 = iUserMapper.findById(1);

        System.out.println(user1 == user2);
    }

    @Test
    public void firstLevelCacheTest3() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        IUserMapper mapper1 = sqlSession1.getMapper(IUserMapper.class);
        IUserMapper mapper2 = sqlSession2.getMapper(IUserMapper.class);
        IUserMapper mapper3 = sqlSession3.getMapper(IUserMapper.class);

        User user1 = mapper1.findById(1);
        sqlSession1.clearCache();//删除一级缓存

        User user3 = mapper3.findById(1);
        user3.setId(1);
        user3.setUsername("list");
        mapper3.update(user3);
        sqlSession3.commit();

        User user2 = mapper2.findById(1);

        System.out.println(user1 == user2);
    }
}
