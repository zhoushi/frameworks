package com.zhou.Patten.command;

/**
 * Created by Administrator on 2017/1/18.
 */
public enum  Visibility {

    VISIBLE("visible"),INVISIBLE("invisible"),UNDEFINED("");

    private String title;
    Visibility(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
