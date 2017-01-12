package com.zhou.simple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2017/1/11.
 */
public class ItemQueue {

    private BlockingQueue<Item> queue;

    public ItemQueue(){
        queue = new LinkedBlockingQueue<Item>(5);
    }

    public void put(Item item) throws InterruptedException{
        queue.put(item);
    }

    public Item take() throws InterruptedException{
        return queue.take();
    }
}
