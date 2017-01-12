package com.zhou.rpc.core;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/1/4.
 *
 * rpc线程池封装
 */
public class RpcThreadPool {

    public static Executor getExecutor(int threads,int queues){
        String name = "RpcThreadPool";

        return new ThreadPoolExecutor(threads,threads,0, TimeUnit.MILLISECONDS,
                queues ==0?new SynchronousQueue<Runnable>():(queues<0?new LinkedBlockingQueue<Runnable>():new LinkedBlockingQueue<Runnable>(queues)),
                new NamedThreadFactory(name, true), new AbortPolicyWithReport(name));
    }
}
