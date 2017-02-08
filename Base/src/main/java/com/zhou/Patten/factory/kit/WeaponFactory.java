package com.zhou.Patten.factory.kit;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/1/16.
 */
public interface WeaponFactory {

    Weapon create(WeaponType name);

    //默认的静态方法
    static WeaponFactory factory(Consumer<Builder> consumer){
        HashMap<WeaponType,Supplier<Weapon>> map = new HashMap<>();
        //将方法放入map中
        consumer.accept(map::put);
        return name -> map.get(name).get();
    }
}
