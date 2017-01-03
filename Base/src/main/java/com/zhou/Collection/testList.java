package com.zhou.Collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class testList {

    public static void main(String[] args){

        List list = Lists.newArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        for (Object s:list){
            //索引
            list.add("s");
            System.out.println(s);
        }
    }
}
