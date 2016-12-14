package com.zhou.Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ArrayListMultiThread {

    static ArrayList<Integer> a1 = new ArrayList<>(10);


    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i<100000;i++){
                a1.add(i);
            }
        }
    }

    /**
     * 由于没有锁的保护机制，另外一个线程访问到了不一致的内部状态，导致出现越界问题
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a1.size());
    }
}
