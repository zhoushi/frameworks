package com.zhou.Api;

/**
 * Created by Administrator on 2016/12/8.
 */

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * 实现服务消费者获取服务提供者地址列表
 */
public class ServiceConsumer {

    public static void main(String...args){
        String serviceName = "service-B";
        String zkServerList = "192.168.136.130:2181";
        String SERVICE_PATH = "/configcenter/"+serviceName;

        ZkClient zkClient = new ZkClient(zkServerList);

        boolean serviceExists = zkClient.exists(SERVICE_PATH);
        List<String> children;
        if (serviceExists){
            children = zkClient.getChildren(SERVICE_PATH);
        }else {
            throw new RuntimeException("service not exist");
        }

        //注册事件监听
        zkClient.subscribeChildChanges(SERVICE_PATH, new IZkChildListener() {
            public void handleChildChange(String s, List<String> list) throws Exception {
//                children = currentChilds;
            }
        });
    }
}
