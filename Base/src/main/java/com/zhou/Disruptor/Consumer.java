package com.zhou.Disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId()+":Event: --"+event.getValue()*event.getValue()+"--");
    }
}
