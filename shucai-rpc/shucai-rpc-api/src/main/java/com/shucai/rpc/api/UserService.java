package com.shucai.rpc.api;

import com.shucai.rpc.pojo.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getById(int id);
}
