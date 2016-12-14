package com.zhou.Disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2016/12/14.
 */
public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){

        long sequence = ringBuffer.next();

        try {
            PCData event = ringBuffer.get(sequence);
            event.setValue(bb.getLong());
        }finally {
            ringBuffer.publish(sequence);
        }
    }
}
