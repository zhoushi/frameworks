package com.zhou.simple;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Producer {

    private final ItemQueue queue;

    private final String name;

    private int itemId;

    public Producer(ItemQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void produce()throws InterruptedException{
        Item item = new Item(name,itemId++);
        queue.put(item);
        Random random = new Random();
        Thread.sleep(random.nextInt(2000));
    }
}
