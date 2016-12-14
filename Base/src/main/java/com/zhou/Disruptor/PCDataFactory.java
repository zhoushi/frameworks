package com.zhou.Disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by Administrator on 2016/12/14.
 */
public class PCDataFactory implements EventFactory<PCData> {
    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
