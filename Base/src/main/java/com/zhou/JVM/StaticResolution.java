package com.zhou.JVM;

/**
 * Created by Administrator on 2017/2/7.
 */
public class StaticResolution {

    public static void sayHello(){
        System.out.println("hello world");
    }

    public static void main(String[] args){
        StaticResolution.sayHello();
    }
}
