package com.zhou;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/10.
 */
public class Test {

    String b1 = "c";
    public static void main(String[] args){

//        String a = "aac";
////        System.out.println(a.getClass());
//        String c = "aa";
//        String b = c+"c";
//
//        System.out.println(a==b);
//
//        //intern方法返回了String对象在常量池中的引用
//        String f= new String("aa");
//        System.out.println(f.getClass());
//
//        System.out.println(a==f);
//
//        Test test = new Test();

        List<String> list = new ArrayList<>();

        list.add("a");

        list = new ArrayList<>();

        list.add("bb");
        System.out.println(list.get(0));


    }

    private void changeString(String a){
        a = a+"c";
    }

}
