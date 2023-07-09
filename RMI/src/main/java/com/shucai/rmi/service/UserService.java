package com.shucai.rmi.service;

import com.shucai.rmi.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    User getByUserId(int id) throws RemoteException;
}
