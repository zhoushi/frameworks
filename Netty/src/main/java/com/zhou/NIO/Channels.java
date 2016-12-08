package com.zhou.NIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Administrator on 2016/12/2.
 */

/**
 * 读取数据到buffer中去
 */
public class Channels {

    public static void main(String...args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D://data/nio-data.txt","rw");

        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //read into buffer
        int bytesRead = inChannel.read(buf);

        System.out.println("Read"+bytesRead);
        while (bytesRead!=-1){
            buf.flip();
            while (buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
    }
}
