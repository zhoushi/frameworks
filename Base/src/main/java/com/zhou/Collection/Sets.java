package com.zhou.Collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Sets {


    public static void main(String[] args){

        Set<Person> set = new HashSet<>();
        //由于set中不能存放重复的对象，所以必须要重写equals和hashcode方法
        Person p = new Person("zhou",18);
        Person p1 = new Person("zhou",18);
        set.add(p);
        set.add(p1);

        for (Person ps:set) {
            System.out.println(ps.toString());
        }
    }
}
