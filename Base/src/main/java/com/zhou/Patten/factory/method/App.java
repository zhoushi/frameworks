package com.zhou.Patten.factory.method;

/**
 * Created by Administrator on 2017/1/16.
 */
public class App {

    private final Blacksmith blacksmith;

    public App(Blacksmith blacksmith){
        this.blacksmith = blacksmith;
    }

    public static void main(String[] args){
        App app = new App(new OrcBlacksmith());
        app.manufactureWeapons();

    }

    private void manufactureWeapons(){
        Weapon weapon;
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(weapon);
    }
}
