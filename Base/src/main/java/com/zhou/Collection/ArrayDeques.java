package com.zhou.Collection;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Administrator on 2017/1/11.
 */
public class ArrayDeques {

    public static void main(String[] args){

        Queue arrayDeque = new ArrayDeque(1);

        arrayDeque.offer("aa");
        arrayDeque.offer("aa1");
        arrayDeque.offer("aa2");
        arrayDeque.offer("aa3");
        arrayDeque.offer("aa4");
        arrayDeque.offer("aa5");
        arrayDeque.offer("aa6");
        arrayDeque.offer("aa7");
        arrayDeque.offer("aa8");
        arrayDeque.offer("aa9");
        System.out.println(arrayDeque.size());

    }
}
