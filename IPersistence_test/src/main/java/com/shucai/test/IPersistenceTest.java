package com.shucai.test;

import com.shucai.dao.IUserDao;
import com.shucai.io.Resources;
import com.shucai.pojo.User;
import com.shucai.sqlSession.SqlSession;
import com.shucai.sqlSession.SqlSessionFactory;
import com.shucai.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.testng.annotations.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
//        User user2 = sqlSession.selectOne("user.selectOne", user);
//        System.out.println(user2);
//        List<User> objects = sqlSession.selectList("user.selectList");
//        for (User object : objects) {
//            System.out.println(object);
//        }
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> all = userDao.findAll();

        for (User user1 : all) {
            System.out.println(user1);
        }
    }

    @Test
    public void testListOne() throws PropertyVetoException, DocumentException {
        InputStream resourcesAsStream = Resources.getResourcesAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourcesAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("张三");

        User user = userDao.findByCondition(user1);
        System.out.println(user);
    }
}
