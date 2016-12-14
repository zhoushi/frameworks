package com.zhou.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock)throws InterruptedException{
        try {
            lock.lock();//模拟读操作
            Thread.sleep(1000);//读操作的耗时越多，读写锁的优势就越明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    public Object handleWrite(Lock lock,int index)throws InterruptedException{
        try {
            lock.lock();//模拟写操作
            Thread.sleep(1000);
            return index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        Runnable readRunnale = new Runnable() {
            @Override
            public void run() {

                try {
                    demo.handleRead(readLock);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnale = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock,new Random().nextInt());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        for (int i =0;i<18;i++){
            new Thread(readRunnale).start();
        }

        for (int i =0;i<18;i++){
            new Thread(writeRunnale).start();
        }
    }

}
