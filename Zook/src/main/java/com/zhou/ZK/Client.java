package com.zhou.ZK;

import com.zhou.Rmi.HelloService;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/12/12.
 */
public class Client {

    public static void main(String...args) throws RemoteException, InterruptedException {
        ServiceConsumer consumer = new ServiceConsumer();

        while (true){
            HelloService helloService = consumer.lookup();
            String result = helloService.sayHello("Jack");
            System.out.println(result);
            Thread.sleep(3000);
        }
    }
}
