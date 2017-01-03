package com.zhou.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2017/1/3.
 */
public class ReferenceDemo {

    static AtomicReference<Integer> money = new AtomicReference<>();


    public static void main(String[] args){
        money.set(19);

        for (int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        while (true){
                            Integer m = money.get();
                            if (m<20){
                                if (money.compareAndSet(m,m+20)){
                                    System.out.println("余额小于20元，充值成功，余额："+money.get()+"元");
                                    break;
                                }
                            }else {
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
    }
}
