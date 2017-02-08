package com.zhou.Patten.command;

/**
 * Created by Administrator on 2017/1/18.
 */
public enum Size {

    SMALL("small"),NORMAL("normal"),LARGE("large"),UNDEFINED("");

    private String title;

    Size(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
