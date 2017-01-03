package com.zhou.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/12/29.
 */
public class ReenterLockCondition implements  Runnable {
    //重入锁
    public static ReentrantLock lock = new ReentrantLock();
    //condition 条件
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {

        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition t1 = new ReenterLockCondition();
        Thread t2 = new Thread(t1);

        t2.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
