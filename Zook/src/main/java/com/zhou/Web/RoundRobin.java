package com.zhou.Web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/8.
 */
public class RoundRobin {


    public static void main(String...args){


    }
    //轮询
    public static String testRoundRobin(){
        //初始化Map变量来表示服务器地址和权重的映射
        Map<String,Integer> serverWeightMap = new HashMap<String, Integer>();
        serverWeightMap.put("192.168.1.100",1);
        serverWeightMap.put("192.168.1.101",1);
        //权重为4
        serverWeightMap.put("192.168.1.102",4);
        serverWeightMap.put("192.168.1.103",1);
        serverWeightMap.put("192.168.1.104",1);
        //权重为3
        serverWeightMap.put("192.168.1.105",3);
        serverWeightMap.put("192.168.1.106",1);

        serverWeightMap.put("192.168.1.107",2);
        serverWeightMap.put("192.168.1.108",1);
        serverWeightMap.put("192.168.1.109",1);
        serverWeightMap.put("192.168.1.110",1);

        Map<String,Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serverWeightMap);

        //取得IP地址list
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        String server = null;
        Integer pos = new Integer(1);
        synchronized (pos){
            if (pos>=keySet.size()){
                pos = 0;
            }

            server = keyList.get(pos);
            pos++;
        }
        return server;
    }
}
