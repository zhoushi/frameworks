package com.zhou.concurrent;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ArrayListMultiThread {
    static ArrayList<Integer> a1 = Lists.newArrayList();

    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<1000000;i++){
                a1.add(i);
            }
        }
    }

    public static void main(String[] args)throws InterruptedException{
        Thread t1 = new Thread(new com.zhou.Thread.ArrayListMultiThread.AddThread());
        Thread t2 = new Thread(new com.zhou.Thread.ArrayListMultiThread.AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a1.size());
    }
}
