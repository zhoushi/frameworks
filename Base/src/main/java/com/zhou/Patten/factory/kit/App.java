package com.zhou.Patten.factory.kit;

/**
 * Created by Administrator on 2017/1/16.
 */
public class App {

    public static void main(String[] args){
        WeaponFactory factory = WeaponFactory.factory(builder -> {
           builder.add(WeaponType.AXE,Axe::new);
            builder.add(WeaponType.SPEAR,Spear::new);
        });

        Weapon axe = factory.create(WeaponType.AXE);
        System.out.println(axe);

        Weapon spear = factory.create(WeaponType.SPEAR);
        System.out.println(spear);
    }
}
