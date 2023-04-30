package com.shucai.test;

import com.shucai.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        IUserDao dao = sqlSession.getMapper(IUserDao.class);
//        User user = new User();
//        user.setId(2);
//        User user1 = dao.findByCondition(user);
//        System.out.println(user1);
//        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
//        for (User user : mapper.findAll()) {
//            System.out.println(user);
//        }

        List<User> users = sqlSession.selectList("com.shucai.dao.IUserDao.findAll");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testInsert() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = build.openSession();
        User user = new User();
        user.setId(4);
        user.setUsername("four");
        sqlSession.insert("com.shucai.dao.IUserDao.insert", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        User user = new User();
        user.setId(4);
        user.setUsername("update-four");


        sqlSession.update("com.shucai.dao.IUserDao.update", user);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();


        sqlSession.update("com.shucai.dao.IUserDao.delete", 3);
        sqlSession.commit();
        sqlSession.close();
    }
}
