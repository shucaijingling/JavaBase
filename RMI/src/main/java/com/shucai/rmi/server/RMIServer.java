package com.shucai.rmi.server;

import com.shucai.rmi.service.UserService;
import com.shucai.rmi.service.UserServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI服务端
 */
public class RMIServer {

    public static void main(String[] args) {

        try {
            //注册Registry实例，绑定端口
            Registry registry = LocateRegistry.createRegistry(9998);

            //创建远程对象
            UserService userService = new UserServiceImpl();

            //将远程对象注册到RMI服务器上
            registry.rebind("userService", userService);

            System.out.println("-----------RMI服务端启动成功------------");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
