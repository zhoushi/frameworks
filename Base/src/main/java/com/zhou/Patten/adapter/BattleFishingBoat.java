package com.zhou.Patten.adapter;

/**
 * Created by Administrator on 2017/1/13.
 */
public class BattleFishingBoat implements BattleShip {

    private FishingBoat boat;

    public BattleFishingBoat(){
        boat = new FishingBoat();
    }
    @Override
    public void fire() {

        System.out.println("fire!");
    }

    @Override
    public void move() {

        boat.sail();
    }
}
