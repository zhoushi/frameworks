package com.zhou.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2017/1/11.
 */
public class Maps {

    public static void main(String[] args){

        //map中key要实现equals和hashcode
//        Map<Person,String>  map = new HashMap<>();
//
//        Person person = new Person();
//        person.setName("zhou");
//        person.setAge(18);
//
//        map.put(person,"zhou");
//
//        System.out.println(map.get(person));


        //java8中要使用forEach遍历
        Map<String,String> stringMap = new HashMap<>();

        stringMap.put("aa","zhou");
        stringMap.put("bb","shi");
        stringMap.put("cc","xian");

        for (Map.Entry entry : stringMap.entrySet()){

            System.out.println(entry.getKey());
        }

        //对于map的遍历
        stringMap.forEach((key,value)-> {
            if ("aa".equals(key)){
                System.out.println(key+"+"+value);
            }

        });
    }
}
