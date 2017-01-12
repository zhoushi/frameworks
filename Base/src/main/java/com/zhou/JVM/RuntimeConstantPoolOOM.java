package com.zhou.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){
        //使用List 保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();

        int i =0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
