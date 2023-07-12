package com.shucai.rpc.provider.service;

import com.shucai.rpc.api.UserService;
import com.shucai.rpc.pojo.User;
import com.shucai.rpc.provider.anno.RpcService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RpcService
@Service
public class UserServiceImpl implements UserService {
    Map<Integer, User> userMap = new HashMap<>();

    @Override
    public User getById(int id) {
        if (userMap.size() == 0) {
            User user1 = new User();
            user1.setId(1);
            user1.setName("赵怀真");

            User user2 = new User();
            user2.setId(2);
            user2.setName("云缨");

            userMap.put(user1.getId(), user1);
            userMap.put(user2.getId(), user2);
        }
        return userMap.get(id);
    }
}
