package com.shucai.rmi.client;

import com.shucai.rmi.pojo.User;
import com.shucai.rmi.service.UserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端
 */
public class RMIClient {
    public static void main(String[] args) {

        try {
            //获取registry实例
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9998);

            //获取服务端方法
            UserService userService = (UserService) registry.lookup("userService");
            User user = userService.getByUserId(1);
            User user2 = userService.getByUserId(2);
            System.out.println(user);
            System.out.println(user2);
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
