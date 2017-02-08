package com.zhou.Patten.iterator;

/**
 * Created by Administrator on 2017/2/6.
 */
public class Item {

    private ItemType type;

    private String name;

    public Item(ItemType type,String name){
        this.setType(type);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
