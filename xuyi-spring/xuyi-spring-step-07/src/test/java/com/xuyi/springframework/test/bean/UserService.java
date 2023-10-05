package com.xuyi.springframework.test.bean;

import com.xuyi.springframework.beans.factory.DisposableBean;
import com.xuyi.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

    private String uId;

    private String company;

    private String location;

    private UserDao userDao;


    @Override
    public void destroy() throws Exception {
        System.out.println("执行  UserService destroy");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("执行 UserService afterPropertiesSet");
    }

    public void testInit() {
        System.out.println("init-method 2");
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
}
