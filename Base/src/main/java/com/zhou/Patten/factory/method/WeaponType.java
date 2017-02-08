package com.zhou.Patten.factory.method;

/**
 * Created by Administrator on 2017/1/16.
 */
public enum WeaponType {

    SHORT_SWORD("short sword"),SPEAR("spear"),AXE("axe"),UNDEFINED("");

    private String title;
    WeaponType(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
