package com.zhou.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ThreadFactory {

    public static void main(String[] args)throws InterruptedException{
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new java.util.concurrent.ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t= new Thread(r);
                t.setDaemon(true);
                System.out.println("create"+t);
                return t;
            }
        });

        for (int i =0;i<5;i++){
            es.submit(task);
        }
        Thread.sleep(2000);
    }
}
