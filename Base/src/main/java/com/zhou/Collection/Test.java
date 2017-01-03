package com.zhou.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
public class Test {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

//        for (String s:list){
//            if (s.equals("b")){
//                list.remove(s);
//                list.add("c");
//            }
//            System.out.println(s);
//        }
//        while (list.iterator()){
//
//        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            if (str.equals("b")){
                list.remove(str);
            }

            System.out.println(str);
        }



    }
}
