package com.shucai.dao;

import com.shucai.pojo.User;

import java.util.List;

public interface IUserDao {

    //通过代理进行调用

    public List<User> findAll();


    public User findByCondition(User user);
}

