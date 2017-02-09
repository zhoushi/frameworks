package com.zhou.Patten.decorator;

/**
 * Created by Administrator on 2017/2/9.
 */
public class Troll implements Hostile{
    @Override
    public void attack() {
        System.out.println("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        System.out.println("The troll shrieks in horror and runs away!");
    }
}
