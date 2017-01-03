package com.zhou.rpc.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/12/15.
 *
 * 线程工厂
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);
    private final AtomicInteger mThreadNum = new AtomicInteger(1);


    public Thread newThread(Runnable r) {
        return null;
    }
}
