package com.shucai.dao;

import com.shucai.pojo.User;

import java.util.List;

public interface IUserDao {

    public User findByCondition(User user);

    public List<User> findAll();

    public Integer update(User user);

    public Integer insert(User user);

    public Integer delete(Integer id);

    public List<User> findByIds(int[] ids);
}
