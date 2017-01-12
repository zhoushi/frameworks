package com.zhou.Collection;

/**
 * Created by Administrator on 2017/1/9.
 */
public enum Planet {

    MERCURY(3.302e+23,2.439e6),
    NEPTUNE(1.024E+26,2.477E7);
    private final double mass;
    private final double radius;
//    private final double surfaceGravity;

    Planet(double mass,double radius){
        this.mass = mass;
        this.radius = radius;

    }
}
