package com.zhou.ZK;


import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProvider.class);

    private CountDownLatch latch = new CountDownLatch(1);

    //发布RMI服务 并注册RMI地址到Zookeeper中
    public void publish(Remote remote,String host,int port){
        String url = publishService(remote,host,port);
        if (url!=null){
            ZooKeeper zk = connectServer();
            if (zk!=null){
                createNode(zk,url);
            }
        }
    }

    //发布RMI服务
    private String publishService(Remote remote,String host,int port){
        String url = null;
        try {
            url = String.format("rmi://%s:%d/%s",host,port,remote.getClass());
            LocateRegistry.createRegistry(port);
            Naming.rebind(url,remote);
            LOGGER.debug("publish rmi service (url: {})",url);
        }catch (RemoteException | MalformedURLException e){
            LOGGER.error("",e);
        }
        return url;
    }

    //连接Zookeeper服务器
    private ZooKeeper connectServer(){
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected){
                        latch.countDown();
                    }
                }
            });
            latch.await();
        }catch (Exception e){
            LOGGER.error("",e);
        }

        return zk;
    }

    //创建ZNode
    private void createNode(ZooKeeper zk,String url){
        try {
            byte[] data = url.getBytes();
            String path = zk.create(Constant.ZK_PROVIDER_PATH,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            LOGGER.debug("create zookeeper node({} => {})",path,url);
        }catch (Exception e){
            LOGGER.error("",e);
        }
    }
}
