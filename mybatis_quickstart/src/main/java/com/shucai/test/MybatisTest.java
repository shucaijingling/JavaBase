package com.shucai.test;

import com.shucai.dao.IUserDao;
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
//        User user = new User();
//        user.setId(5);
//        user.setUsername("four");
//        sqlSession.insert("com.shucai.dao.IUserDao.insert", user);
//        for (int i = 5; i <= 10; i++) {
//            User user = new User();
//            user.setId(i);
//            user.setUsername("new" + i);
//            IUserDao mapper = sqlSession.getMapper(IUserDao.class);
//            mapper.insert(user);
//        }
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("五月");

        Integer id = mapper.insert(user);
        System.out.println(user.getId());
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


//        sqlSession.update("com.shucai.dao.IUserDao.delete", 3);
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(4);
        user.setUsername("new-user");


        mapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testforDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        for (int i = 5; i <= 10; i++) {
            mapper.delete(i);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testForFindByCondition() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("五月-2");
        User byCondition = mapper.findByCondition(user);
        System.out.println(byCondition);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testForFindInIds() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        List<User> userList = mapper.findByIds(arr);
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user);
        }
        sqlSession.close();
    }
}
