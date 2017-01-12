package com.zhou.Collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Sets {


    public static void main(String[] args){
        Set set = new HashSet();
        set.add("a");
        set.add("b");

        for (Object s:set){
            System.out.println(s.toString());
        }
    }
}
