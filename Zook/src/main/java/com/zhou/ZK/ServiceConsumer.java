package com.zhou.ZK;

/**
 * Created by Administrator on 2016/12/12.
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 服务消费者
 */
public class ServiceConsumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceConsumer.class);
    
    private CountDownLatch latch = new CountDownLatch(1);
    
    //定义一个volatile成员变量，用于保存最新的RMI地址
    private volatile List<String> urlList = new ArrayList<>();
    
    public ServiceConsumer(){
        ZooKeeper zk = connectServer();
        if (zk!=null){
            watchNode(zk);//观察/registry节点的所有子节点并更新
        }
    }
    //查找RMI服务
    public <T extends Remote> T lookup(){
        T service = null;
        int size = urlList.size();
        if (size>0){
            String url;
            if (size == 1){
                url = urlList.get(0);
                LOGGER.debug("using only url:{}",url);
            }else {
                url = urlList.get(ThreadLocalRandom.current().nextInt(size));
            }
            
            service = lookupService(url);//从JNDI中查找RMI服务
        }
        return service;
    }

    private <T extends Remote> T lookupService(String url) {
        T remote = null;
        try {
            remote = (T) Naming.lookup(url);
        }catch (NotBoundException | MalformedURLException | RemoteException e){
            if (e instanceof ConnectException){
                LOGGER.error("ConnectException->url:{}",url);
                if (urlList.size()!=0){
                    url = urlList.get(0);
                    return lookupService(url);
                }
            }
            LOGGER.error("",e);
        }
        return remote;
    }

    private void watchNode(final ZooKeeper zk) {
        try {
            List<String> nodeList = zk.getChildren(Constant.ZK_REGISTRY_PATH, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged){
                        watchNode(zk);
                    }
                }
            });

            List<String> dataList = new ArrayList<>();

            for (String node : nodeList){
                byte[] data = zk.getData(Constant.ZK_REGISTRY_PATH+"/"+node,false,null);
                dataList.add(new String(data));
            }
            LOGGER.debug("node data: {}",dataList);
            urlList = dataList;
        }catch (Exception e){
            LOGGER.error("",e);
        }
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
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
}
