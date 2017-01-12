package com.zhou.JVM;

/**
 * Created by Administrator on 2017/1/12.
 */
public class ThreadAnalytics {

    /**
     * 线程死循环演示
     */
    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    ;
            }
        },"testBusyThread");
        thread.start();
    }
}
