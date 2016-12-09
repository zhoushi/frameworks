package com.zhou.Rmi;

import java.rmi.Naming;

/**
 * Created by Administrator on 2016/12/9.
 */

/**
 * 使用rmi远程调用
 */
public class RmiClient {

    public static void main(String[] args)throws Exception{
        String url = "rmi://localhost:1099/com.zhou.Rmi.HelloServiceImpl";

        HelloService helloService = (HelloService) Naming.lookup(url);

        String result = helloService.sayHello("Jack");
        System.out.println(result);
    }
}
