package com.shucai.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

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
    private IUserMapper iUserMapper;
    private IOrderMapper iOrderMapper;
    @Before
    public void createSqlSession() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        iUserMapper = sqlSession.getMapper(IUserMapper.class);
        iOrderMapper = sqlSession.getMapper(IOrderMapper.class);
    }

    @Test
    public void testAnnoInsert() {
        User user = new User();
        user.setId(3);
        user.setUsername("insert data");
        iUserMapper.insert(user);
    }

    @Test
    public void testAnnoUpdate() {
        User user = new User();
        user.setId(3);
        user.setUsername("update data");
        iUserMapper.update(user);
    }


    @Test
    public void testAnnoSelect() {

        for (User user : iUserMapper.selectAll()) {
            System.out.println(user);
        }

    }

    @Test
    public void testAnnoDelete() {

        iUserMapper.delete(3);
    }

    @Test
    public void testAnnoSelectMuti(){
        for (Order order : iOrderMapper.findOrderAndUser2()) {
            System.out.println(order);
        }
    }

    @Test
    public void testAnnoSelectMutiUser(){
        for (User user : iUserMapper.findAll2()) {
            System.out.println(user);
        }

    }

    @Test
    public void testFindUserOrder(){
        for (User user : iUserMapper.findUserAndRole2()) {

            System.out.println(user);
        }
    }

    @Test
    public void pageHelperTest(){

        PageHelper.startPage(1,1);
        List<User> users = iUserMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println("当前页数"+pageInfo.getPageNum());
        System.out.println("总页数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
    }
}
