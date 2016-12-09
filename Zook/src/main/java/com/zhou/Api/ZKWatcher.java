package com.zhou.Api;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by Administrator on 2016/12/8.
 */

/**
 * watcher实现
 */
public class ZKWatcher implements Watcher {
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeDeleted){
            System.out.println("node delete");
        }
        if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged){

        }
    }
}
