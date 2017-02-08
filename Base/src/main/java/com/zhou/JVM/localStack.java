package com.zhou.JVM;

/**
 * Created by Administrator on 2017/2/6.
 * 局部变量表
 */
public class localStack {

    public static void main(String[] args){
//        byte[] placeholder = new byte[64*1024*1024];
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        //不使用的对象应手动赋值为null
        System.gc();
    }
}
