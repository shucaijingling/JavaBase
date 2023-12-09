package com.shucai.local.service;

import com.shucai.local.pojo.UserInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔬菜精灵
 */
public class UserServiceImpl extends UnicastRemoteObject implements IUserService {
    
     Map<Integer, UserInfo> map = new HashMap<>();
     
    public UserServiceImpl() throws RemoteException {
        super();
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1);
        userInfo1.setName("NO.1");
        
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setName("NO.2");
        
        map.put(1, userInfo1);
        map.put(2, userInfo2);
    }
    
    @Override
    public UserInfo getUserInfo(int id) throws RemoteException {
        return map.get(id);
    }
}
