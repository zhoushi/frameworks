package com.zhou.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */
public class CollectionsDemo {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        Collections.sort(list);
        Collections.max(list);

        for (String s: list) {
            System.out.println(s);
        }
    }
}
