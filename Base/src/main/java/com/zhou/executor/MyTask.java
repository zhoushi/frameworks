package com.zhou.executor;

/**
 * Created by Administrator on 2016/12/29.
 */
public class MyTask  implements  Runnable{
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread().getId());

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
