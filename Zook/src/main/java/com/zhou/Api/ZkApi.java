package com.zhou.Api;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;

/**
 * Created by Administrator on 2016/12/8.
 */
public class ZkApi {

    public static void main(String...args) throws IOException, KeeperException, InterruptedException {
        String url = "127.0.0.1";
        int sessionTimeOut = 60;
        ZooKeeper zooKeeper = new ZooKeeper(url,sessionTimeOut,null);

        //创建zookeeper节点
//        zooKeeper.create("/root","root data".getBytes(), OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //删除节点
//        zooKeeper.delete("/root",-1);
        //设置和获取节点内容
        zooKeeper.setData("/root","hello".getBytes(),-1);
        //取得/root节点的数据，并返回其stat
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/root",false,stat);
        String s = new String(data);
        //添加子节点
//        zooKeeper.create("/root/child","child data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        //判断节点是否存在
        Stat stat1 = zooKeeper.exists("/root/child",false);
        if (stat1 == null){
            System.out.println("节点不存在");
        }else {
            System.out.println("节点存在");
        }
        System.out.println(s.toString());
    }
}
