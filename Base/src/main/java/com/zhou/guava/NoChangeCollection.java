package com.zhou.guava;

import com.google.common.collect.ImmutableList;

import java.util.Iterator;

/**
 * Created by Administrator on 2017/1/11.
 * 不可变集合
 */
public class NoChangeCollection {

    public static final ImmutableList<String> COLOR_NAMES = ImmutableList.of(
            "red","orange","yellow"
    );

    public static void main(String[] args){
//        boolean s = COLOR_NAMES.remove("red");

        ImmutableList<String> strings = COLOR_NAMES.asList();

        System.out.println(COLOR_NAMES.size());
        System.out.println(strings);

        Iterator iterator = COLOR_NAMES.iterator();

        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.toString());
        }
    }
}
