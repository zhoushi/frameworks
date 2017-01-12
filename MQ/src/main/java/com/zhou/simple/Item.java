package com.zhou.simple;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Item {

    private String producer;
    private int id;

    public Item(String producer, int id) {
        this.producer = producer;
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
