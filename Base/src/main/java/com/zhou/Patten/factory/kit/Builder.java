package com.zhou.Patten.factory.kit;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2017/1/16.
 */
public interface Builder {

    void add(WeaponType name, Supplier<Weapon> supplier);
}
