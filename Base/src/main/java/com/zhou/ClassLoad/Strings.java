package com.zhou.ClassLoad;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Strings {

    public static void main(String[] args){

        String a = "bc";//栈中引用 "bc"
        String b = "b"; //栈中引用"b"

        String c = b+"c";//由于String value是final的所以c 引用另一个地址
        System.out.println(a==c);
    }
}
