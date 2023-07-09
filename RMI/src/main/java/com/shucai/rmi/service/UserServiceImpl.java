package com.shucai.rmi.service;

import com.shucai.rmi.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl extends UnicastRemoteObject implements UserService{

    Map<Integer, User> userMap = new HashMap<>();
    public UserServiceImpl() throws RemoteException {
        super();
        User user1 = new User();
        user1.setId(1);
        user1.setName("诸葛亮");

        User user2 = new User();
        user2.setId(2);
        user2.setName("李白");

        userMap.put(1,user1);
        userMap.put(2,user2);
    }

    @Override
    public User getByUserId(int id) throws RemoteException{
        return userMap.get(id);
    }
}
