package com.shucai.local.service;

import com.shucai.local.pojo.UserInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author 蔬菜精灵
 */
public interface IUserService extends Remote {
    
    UserInfo getUserInfo(int id) throws RemoteException;
}
