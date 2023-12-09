package com.shucai.local.client;

import com.alibaba.fastjson.JSON;
import com.shucai.local.service.IUserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author 蔬菜精灵
 */
public class RMIClient {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        
        IUserService userService = (IUserService) registry.lookup("userService");
        
        System.out.println(JSON.toJSONString(userService.getUserInfo(1)));
        System.out.println(JSON.toJSONString(userService.getUserInfo(2)));
    }
}
