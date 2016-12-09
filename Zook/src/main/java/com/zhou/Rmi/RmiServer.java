package com.zhou.Rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Administrator on 2016/12/9.
 */
public class RmiServer {

    public static void main(String[] args)throws Exception{
        int port = 1099;
        //提供服务
        String url = "rmi://localhost:1099/com.zhou.Rmi.HelloServiceImpl";
        LocateRegistry.createRegistry(port);
        Naming.rebind(url,new HelloServiceImpl());
    }
}
