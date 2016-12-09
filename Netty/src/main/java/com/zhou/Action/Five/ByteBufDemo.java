package com.zhou.Action.Five;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Random;

/**
 * Created by Administrator on 2016/12/9.
 */
public class ByteBufDemo {

    public static void randomAccessIndex(){
        ByteBuf buf = Unpooled.buffer(16);

        for (int i=0;i<16;i++){
            buf.writeByte(i+1);
        }

        for (int i=0;i<buf.capacity();i++){
            System.out.println(buf.getByte(i));
        }
    }

    //可读字节
    public static void readBytes(){
        ByteBuf buf = Unpooled.buffer(16);

        while (buf.isReadable()){
            System.out.println(buf.readByte());
        }
    }

    //可写字节
    public static void writeBytes(){
        Random random = new Random();
        ByteBuf buf = Unpooled.buffer(16);
        while (buf.writableBytes()>=4){
            buf.writeInt(random.nextInt());
        }
    }

}
