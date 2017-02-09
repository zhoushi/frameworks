package com.zhou.Patten.decorator;

/**
 * Created by Administrator on 2017/2/9.
 */
public class App {

    public static void main(String[] args){
        System.out.println("A simple looking troll approaches.");

        Hostile troll = new Troll();
        troll.attack();
        troll.fleeBattle();

        System.out.println("");

        System.out.println("\nA smart looking troll surprises you.");
        Hostile smart = new SmartHostile(troll);
        smart.attack();
        smart.fleeBattle();
        System.out.printf("Smart troll power %d.\n", smart.getAttackPower());
    }
}
