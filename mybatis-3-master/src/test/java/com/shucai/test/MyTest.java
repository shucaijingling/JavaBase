package com.shucai.test;

import com.lagou.mapper.IUserMapper;
import com.lagou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {

    @Test
    public void test1() throws IOException {
        //1.读取配置文件成字节输入流
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        //2.解析配置文件，封装Configuration, 创建DefaultSqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3.生产了DefaultSqlSession对象  设置了事务不自动提交  完成executor对象的创建
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. (1) 根据statementId从Configuration Map中获取MappedStatement对象
        //   (2) 将查询任务委派给executor执行器
        //   (3) executor执行器将查询任务交给StatementHandler执行
        List<Object> objects = sqlSession.selectList("namespace.id");
    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用JDK动态代理对mapper接口产生代理对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        for (User user : mapper.findAll()) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sessionFactory.openSession();
        SqlSession sqlSession2 = sessionFactory.openSession();

        User user1 = sqlSession1.selectOne("com.lagou.mapper.IUserMapper.findById", 1);
        System.out.println(user1);
        sqlSession1.commit();

        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        //增删改查会清空二级缓存
        sqlSession1.update("com.lagou.mapper.IUserMapper.updateById", user);

        User user2 = sqlSession2.selectOne("com.lagou.mapper.IUserMapper.findById", 1);
        System.out.println(user2);
    }
}
