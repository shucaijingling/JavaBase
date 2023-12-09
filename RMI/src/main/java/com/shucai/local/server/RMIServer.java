package com.shucai.local.server;

import com.shucai.local.service.UserServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author 蔬菜精灵
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(9999);
        
        UserServiceImpl userService = new UserServiceImpl();
        registry.rebind("userService", userService);
    }
}
