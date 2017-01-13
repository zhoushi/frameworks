package com.zhou.Patten.adapter;

/**
 * Created by Administrator on 2017/1/13.
 */
public class App {

    public static void main(String[] args){
        Captain captain = new Captain(new BattleFishingBoat());

        captain.move();
        captain.fire();
    }
}
