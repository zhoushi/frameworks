package com.zhou.simple;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Consumer {

    private final ItemQueue queue;

    private final String name;

    public Consumer(ItemQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void consume() throws InterruptedException{
        Item item = queue.take();
        System.out.println(String.format("Consumer [%s] consume item [%s] produced by [%s]", name,
                item.getId(), item.getProducer()));
    }
}
