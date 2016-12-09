package com.zhou.Rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Administrator on 2016/12/9.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s",name);
    }
}
