package com.zhou.Patten.adapter;

/**
 * Created by Administrator on 2017/1/13.
 */
public class Captain implements BattleShip {

    private BattleShip battleShip;

    public Captain(){

    }

    public Captain(BattleShip battleShip){
        this.battleShip = battleShip;
    }
    @Override
    public void fire() {

        battleShip.fire();
    }

    @Override
    public void move() {
        battleShip.move();
    }
}
