package com.zhou.concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/12/14.
 */
public class ThreadLocalDemo {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //改进版，使用ThreadLocal
    private static final ThreadLocal<SimpleDateFormat> sdfs = new ThreadLocal<>();

    public static class ParseDate implements Runnable{

        int i = 0;
        public ParseDate(int i){
            this.i = i;
        }
        @Override
        public void run() {
            try {

                if (sdfs.get()==null){
                    sdfs.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t = sdfs.get().parse("2015-03-29 19:29:"+i%60);
                System.out.println(i+":"+t);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i=0;i<1000;i++){
            es.execute(new ParseDate(i));
        }
    }
}