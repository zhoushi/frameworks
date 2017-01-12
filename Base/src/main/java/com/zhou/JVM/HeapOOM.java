package com.zhou.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */
public class HeapOOM {

    static class OOMObject{

    }

    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
