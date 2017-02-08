package com.zhou.Patten.factory.method;

/**
 * Created by Administrator on 2017/1/16.
 */
public class ElfWeapon implements Weapon {
    private WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType){
        this.weaponType = weaponType;
    }
    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public String toString() {
        return "Elven"+weaponType;
    }
}
