package com.zhou.ZK;

import com.zhou.Rmi.HelloService;
import com.zhou.Rmi.HelloServiceImpl;

/**
 * Created by Administrator on 2016/12/12.
 */
public class Server {

    public static void main(String[] args)throws Exception{
        if (args.length!=2){
            System.err.println("please using command:");
            System.exit(-1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        ServiceProvider provider = new ServiceProvider();

        HelloService helloService = new HelloServiceImpl();
        provider.publish(helloService,host,port);
        Thread.sleep(Long.MAX_VALUE);
        System.in.read();
    }
}
