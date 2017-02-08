package com.zhou.executor.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/1/18.
 */
public class ExecutorTest {

    public static void main(String[] args){
        Executor executor = Executors.newFixedThreadPool(10);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");

            }
        });
    }
}
