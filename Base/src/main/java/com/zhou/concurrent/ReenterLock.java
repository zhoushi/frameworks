package com.zhou.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/12/14.
 *
 * 重入锁
 */
public class ReenterLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j =0;j<10000000;j++){
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }
    }
}
