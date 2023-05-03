package com.shucai.test;

import com.shucai.mapper.IOrderMapper;
import com.shucai.mapper.IUserMapper;
import com.shucai.muti.pojo.Order;
import com.shucai.muti.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {


    @Test
    public void testSelect() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IOrderMapper mapper = sqlSession.getMapper(IOrderMapper.class);
        for (Order order : mapper.findOrderAndUser()) {
            System.out.println(order);
        }
    }


    @Test
    public void testForFindAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        for (User user : mapper.findAll()) {
            System.out.println(user);
//            System.out.println(user.getOrderList());
        }

    }

    @Test
    public void testFindUserAndRole() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        for (User user : mapper.findUserAndRole()) {
            System.out.println(user);
        }
    }

    /**
     * 抽取创建sqlsession步骤
     */
    private IUserMapper IUserMapper;
    private IOrderMapper IOrderMapper;
    @Before
    public void createSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        IUserMapper = sqlSession.getMapper(IUserMapper.class);
        IOrderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void testAnnoInsert() {
        User user = new User();
        user.setId(3);
        user.setUsername("insert data");
        IUserMapper.insert(user);
    }

    @Test
    public void testAnnoUpdate() {
        User user = new User();
        user.setId(3);
        user.setUsername("update data");
        IUserMapper.update(user);
    }


    @Test
    public void testAnnoSelect() {

        for (User user : IUserMapper.selectAll()) {
            System.out.println(user);
        }

    }

    @Test
    public void testAnnoDelete() {

        IUserMapper.delete(3);
    }

    @Test
    public void testAnnoSelectMuti(){
        for (Order order : IOrderMapper.findOrderAndUser2()) {
            System.out.println(order);
        }
    }

    @Test
    public void testAnnoSelectMutiUser(){
        for (User user : IUserMapper.findAll2()) {
            System.out.println(user);
        }

    }
}
