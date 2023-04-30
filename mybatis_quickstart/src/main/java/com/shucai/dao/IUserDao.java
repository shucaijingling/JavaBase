package com.shucai.dao;

import com.shucai.pojo.User;

import java.util.List;

public interface IUserDao {

    public User findByCondition(User user);

    public List<User> findAll();
}
