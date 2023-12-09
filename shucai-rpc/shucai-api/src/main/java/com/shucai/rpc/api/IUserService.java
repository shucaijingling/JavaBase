package com.shucai.rpc.api;

import com.shucai.rpc.pojo.User;

/**
 * @author 蔬菜精灵
 */
public interface IUserService {
    
    User getById(int id);
}
