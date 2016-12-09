package com.zhou.Rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/12/9.
 */
public interface HelloService extends Remote {

    String sayHello(String name)throws RemoteException;
}
